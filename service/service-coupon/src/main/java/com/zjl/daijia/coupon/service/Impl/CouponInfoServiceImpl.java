package com.zjl.daijia.coupon.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zjl.daijia.common.constant.RedisConstant;
import com.zjl.daijia.common.exception.BusinessException;
import com.zjl.daijia.common.result.ResultCodeEnum;
import com.zjl.daijia.coupon.mapper.CouponInfoMapper;
import com.zjl.daijia.coupon.mapper.CustomerCouponMapper;
import com.zjl.daijia.coupon.service.CouponInfoService;
import com.zjl.daijia.model.entity.coupon.CouponInfo;
import com.zjl.daijia.model.entity.coupon.CustomerCoupon;
import com.zjl.daijia.model.form.coupon.UseCouponForm;
import com.zjl.daijia.model.vo.base.PageVO;
import com.zjl.daijia.model.vo.coupon.AvailableCouponVO;
import com.zjl.daijia.model.vo.coupon.NoReceiveCouponVO;
import com.zjl.daijia.model.vo.coupon.NoUseCouponVO;
import com.zjl.daijia.model.vo.coupon.UsedCouponVO;
import jakarta.annotation.Resource;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * 优惠券服务实现类
 * <p>
 * Created by Zhangjilin on 2025/6/23
 */
@Service
@SuppressWarnings({"unchecked", "rawtypes"})
public class CouponInfoServiceImpl extends ServiceImpl<CouponInfoMapper, CouponInfo> implements CouponInfoService {

    @Autowired
    private CouponInfoMapper couponInfoMapper;

    @Autowired
    private CustomerCouponMapper customerCouponMapper;

    @Resource
    private RedissonClient redissonClient;

    /**
     * 顾客接收优惠券
     * @param customerId 顾客id
     * @param couponId 优惠券id
     * @return 接收成功标示
     */
    @Override
    public Boolean receive(Long customerId, Long couponId) {
        // 1.通过couponId查询优惠券信息
        CouponInfo couponInfo = couponInfoMapper.selectById(couponId);
        if (couponInfo == null) {
            throw new BusinessException(ResultCodeEnum.DATA_ERROR);
        }

        // 判断优惠券是否过期
        if (couponInfo.getExpireTime().before(new Date())) {
            throw new BusinessException(ResultCodeEnum.COUPON_EXPIRE);
        }

        // 检查库存，发行数量和领取数量
        if (couponInfo.getPublishCount() != 0
            &&
            couponInfo.getReceiveCount() == couponInfo.getPublishCount()) {
            throw new BusinessException(ResultCodeEnum.COUPON_LESS);
        }

        // 开始领取优惠券业务
        RLock lock = null;
        try {
            lock = redissonClient.getLock(RedisConstant.COUPON_LOCK + customerId);
            boolean flag = lock.tryLock(RedisConstant.COUPON_LOCK_WAIT_TIME, RedisConstant.COUPON_LOCK_LEASE_TIME, TimeUnit.SECONDS);
            if (flag) {
                // 检查每个人限制领取数量
                if (couponInfo.getPerLimit() > 0) {
                    LambdaQueryWrapper<CustomerCoupon> wrapper = new LambdaQueryWrapper<>();
                    wrapper.eq(CustomerCoupon::getCouponId, couponId);
                    wrapper.eq(CustomerCoupon::getCustomerId, customerId);
                    Long count = customerCouponMapper.selectCount(wrapper);
                    if (count >= couponInfo.getPerLimit()) {
                        throw new BusinessException(ResultCodeEnum.COUPON_USER_LIMIT);
                    }
                }

                // 领取优惠券
                int row = couponInfoMapper.updateReceiveCount(couponId);

                // 添加领取记录
                this.saveCustomerCoupon(customerId,couponId,couponInfo.getExpireTime());

                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (lock != null) {
                lock.unlock();
            }
        }
        return true;
    }

    /**
     * 查找未使用的最佳优惠券信息
     * @param customerId 顾客id
     * @param orderAmount 订单价钱
     * @return 可用优惠券
     */
    @Override
    public List<AvailableCouponVO> findAvailableCoupon(Long customerId, BigDecimal orderAmount) {

        // 1.创建List集合，存储最终返回的数据
        List<AvailableCouponVO> availableCouponVOList = new ArrayList<>();

        // 2.通过customerId查询顾客已经领取但是未使用的优惠券信息
        List<NoUseCouponVO> list = couponInfoMapper.findNoUseList(customerId);

        // 3.遍历乘客未使用的优惠券列表，得到每个优惠券
        // 3.1 判断优惠卷类型 （现金券 or 折扣券）
        // list.stream()	把 list 转成一个流，用于操作
        //.filter(...)	过滤出 couponType == 1 的优惠券（类型为“现金券”）
        //.collect(Collectors.toList())	把过滤后的结果重新收集成一个 List，赋值给 collect
        List<NoUseCouponVO> cashCouponList = list.stream().filter(item -> item.getCouponType() == 1).collect(Collectors.toList());

        // 3.2 现金券
        for (NoUseCouponVO noUseCouponVO : cashCouponList) {
            // 判断使用门槛
            // 先计算减免金额
            BigDecimal reduceAmount = noUseCouponVO.getAmount();
            // 1. 现金券没有门槛 那么订单金额必须大于优惠减免金额
            if (noUseCouponVO.getConditionAmount().doubleValue() == 0
                &&
                orderAmount.subtract(reduceAmount).doubleValue() > 0) {
                // 加入到可用的优惠券中
                availableCouponVOList.add(this.buildBestNoUseCouponVO(noUseCouponVO, reduceAmount));
            }

            // 2. 现金券有门槛 那么订单金额必须大于优惠券门槛金额
            if (noUseCouponVO.getConditionAmount().doubleValue() > 0
                &&
                orderAmount.subtract(noUseCouponVO.getConditionAmount()).doubleValue() > 0) {
                availableCouponVOList.add(this.buildBestNoUseCouponVO(noUseCouponVO, reduceAmount));
            }
        }

        // 3.3 折扣券
        List<NoUseCouponVO> salesCouponList = list.stream().filter(item -> item.getCouponType() == 2).collect(Collectors.toList());
        for (NoUseCouponVO noUseCouponVO : salesCouponList) {
            // 先算一下折扣后的金额
            BigDecimal disCountAmount = orderAmount.multiply(noUseCouponVO.getDiscount())
                    .divide(new BigDecimal("10"))
                    .setScale(2, RoundingMode.HALF_UP);

            BigDecimal reduceAmount = orderAmount.subtract(disCountAmount);

            // 无门槛折扣券
            if (noUseCouponVO.getConditionAmount().doubleValue() == 0) {
                availableCouponVOList.add(this.buildBestNoUseCouponVO(noUseCouponVO, reduceAmount));
            }

            // 有门槛折扣券
            if (noUseCouponVO.getConditionAmount().doubleValue() > 0
                &&
                disCountAmount.subtract(noUseCouponVO.getConditionAmount()).doubleValue() > 0) {
                availableCouponVOList.add(this.buildBestNoUseCouponVO(noUseCouponVO, reduceAmount));
            }

            // 把满足条件的优惠券放到最终的list集合
            // 根据金额排序
            if (!CollectionUtils.isEmpty(availableCouponVOList)) {
                Collections.sort(availableCouponVOList, new Comparator<AvailableCouponVO>() {
                    @Override
                    public int compare(AvailableCouponVO o1, AvailableCouponVO o2) {
                        return o1.getReduceAmount().compareTo(o2.getReduceAmount());
                    }
                });
            }
        }
        return availableCouponVOList;
    }

    /**
     * 使用优惠券
     * @param useCouponForm 使用优惠券的表单
     * @return 使用后的订单金额
     */
    @Override
    public BigDecimal useCoupon(UseCouponForm useCouponForm) {
        // 根据乘客优惠卷id查询乘客优惠券信息
        CustomerCoupon customerCoupon = customerCouponMapper.selectById(useCouponForm.getCustomerId());
        if (customerCoupon == null) {
            throw new BusinessException(ResultCodeEnum.DATA_ERROR);
        }

        // 根据优惠卷id查出优惠卷信息
        CouponInfo couponInfo = couponInfoMapper.selectById(customerCoupon.getCouponId());
        if (couponInfo == null) {
            throw new BusinessException(ResultCodeEnum.DATA_ERROR);
        }

        // 判断优惠卷是否是当前乘客所拥有的
        if (customerCoupon.getCustomerId() != useCouponForm.getCustomerId()) {
            throw new BusinessException(ResultCodeEnum.DATA_ERROR);
        }

        // 判断乘客是否具有优惠券使用条件
        // 现金和折扣优惠券，根据使用门槛来判断
        BigDecimal reduceAmount = null;
        // 1.现金券
        if (couponInfo.getCouponType() == 1) {
            // 若是没有门槛的，但是订单金额必须大于优惠券减免的金额
            if(couponInfo.getConditionAmount().doubleValue() == 0
                &&
                useCouponForm.getOrderAmount().subtract(couponInfo.getAmount()).doubleValue() > 0) {
                reduceAmount = couponInfo.getAmount();
            }

            // 有门槛，订单金额大于优惠卷门槛金额 conditionAmount就是优惠券的门槛金额
            if (couponInfo.getConditionAmount().doubleValue() > 0
                &&
                useCouponForm.getOrderAmount().subtract(couponInfo.getConditionAmount()).doubleValue() > 0) {
                reduceAmount = couponInfo.getAmount();
            }
        } else {
            // 2. 折扣券
            // 先计算一下折扣后的金额 折扣券中 “9 折” 表示 9.0，不是 0.9；
            // 所以要除以 10 才能还原成真实比例；
            BigDecimal disCountOrderAmount = useCouponForm.getOrderAmount().multiply(couponInfo.getDiscount())
                    .divide(new BigDecimal("10")).setScale(2, RoundingMode.HALF_UP);

            // 订单优惠金额
            // 1. 没门槛
            if (couponInfo.getConditionAmount().doubleValue() == 0) {
                // 优惠金额
                reduceAmount = useCouponForm.getOrderAmount().subtract(disCountOrderAmount);
            }

            // 2. 有门槛，订单折扣后的金额大于优惠券门槛金额 (折扣的金额还要满足门槛啊)
            if (couponInfo.getConditionAmount().doubleValue() > 0
                &&
                disCountOrderAmount.subtract(couponInfo.getConditionAmount()).doubleValue() > 0) {
                // 优惠金额
                reduceAmount = useCouponForm.getOrderAmount().subtract(disCountOrderAmount);
            }
        }

        // 判断完满足条件，更新数据
        if(reduceAmount.doubleValue() > 0) {
            // 更新优惠券使用的数量 coupon_info
            Integer useCount_old = couponInfo.getUseCount();
            couponInfo.setUseCount(useCount_old + 1);
            couponInfoMapper.updateById(couponInfo);

            // 更新顾客的优惠券 customer_coupon
            CustomerCoupon updateCustomerCoupon = new CustomerCoupon();
            updateCustomerCoupon.setCustomerId(customerCoupon.getCustomerId());
            updateCustomerCoupon.setUsedTime(new Date());
            updateCustomerCoupon.setOrderId(useCouponForm.getOrderId());
            customerCouponMapper.updateById(updateCustomerCoupon);

            return reduceAmount;
        }
        return null;
    }

    /**
     * 寻找最佳的未使用优惠券
     * @param noUseCouponVO 未使用的优惠券
     * @param reduceAmount 减免的费用
     * @return 最佳的未使用优惠券
     */
    private AvailableCouponVO buildBestNoUseCouponVO(NoUseCouponVO noUseCouponVO, BigDecimal reduceAmount) {
        AvailableCouponVO bestNoUseCouponVO = new AvailableCouponVO();
        BeanUtils.copyProperties(noUseCouponVO, bestNoUseCouponVO);
        bestNoUseCouponVO.setCouponId(noUseCouponVO.getId());
        bestNoUseCouponVO.setReduceAmount(reduceAmount);
        return bestNoUseCouponVO;
    }

    /**
     * 存储顾客优惠券
     * @param customerId 顾客id
     * @param couponId 优惠券id
     * @param expireTime 过期时间
     */
    private void saveCustomerCoupon(Long customerId, Long couponId, Date expireTime) {
        CustomerCoupon customerCoupon = new CustomerCoupon();
        customerCoupon.setCouponId(couponId);
        customerCoupon.setCouponId(couponId);
        customerCoupon.setCustomerId(customerId);
        customerCoupon.setExpireTime(expireTime);
        customerCoupon.setReceiveTime(new Date());
        customerCoupon.setStatus(1);
        customerCouponMapper.insert(customerCoupon);
    }

    /**
     * 查询顾客已使用的优惠券
     * @param pageParam 分页参数
     * @param customerId 顾客id
     * @return 顾客已使用的优惠券的分页结果
     */
    @Override
    public PageVO<UsedCouponVO> findUsedPage(Page<CouponInfo> pageParam, Long customerId) {
        IPage<UsedCouponVO> pageInfo = couponInfoMapper.findUsedPage(pageParam, customerId);
        return new PageVO(pageInfo.getRecords(), pageInfo.getPages(), pageInfo.getTotal());
    }

    /**
     * 查询没有接收的优惠券
     * @param pageParam 分页参数
     * @param customerId 用户id
     * @return 没有接收的优惠券的分页结果
     */
    @Override
    public PageVO<NoReceiveCouponVO> findNoReceivePage(Page<CouponInfo> pageParam, Long customerId) {
        IPage<NoReceiveCouponVO> pageInfo = couponInfoMapper.findNoReceivePage(pageParam, customerId);
        return new PageVO(pageInfo.getRecords(), pageInfo.getPages(), pageInfo.getTotal());
    }

    /**
     * 查询顾客已经接收但没有使用的优惠券
     * @param pageParam 分页参数
     * @param customerId 顾客id
     * @return 顾客已经接收但没有使用的优惠券的分页结果
     */
    @Override
    public PageVO<NoUseCouponVO> findNoUsePage(Page<CouponInfo> pageParam, Long customerId) {
        IPage<NoUseCouponVO> pageInfo = couponInfoMapper.findNoUsePage(pageParam, customerId);
        return new PageVO<>(pageInfo.getRecords(), pageInfo.getPages(), pageInfo.getTotal());
    }
}
