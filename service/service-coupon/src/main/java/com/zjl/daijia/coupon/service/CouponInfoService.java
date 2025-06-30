package com.zjl.daijia.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zjl.daijia.model.entity.coupon.CouponInfo;
import com.zjl.daijia.model.form.coupon.UseCouponForm;
import com.zjl.daijia.model.vo.base.PageVO;
import com.zjl.daijia.model.vo.coupon.AvailableCouponVO;
import com.zjl.daijia.model.vo.coupon.NoReceiveCouponVO;
import com.zjl.daijia.model.vo.coupon.NoUseCouponVO;
import com.zjl.daijia.model.vo.coupon.UsedCouponVO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.math.BigDecimal;
import java.util.List;

/**
 * 优惠券服务
 * <p>
 * Created by Zhangjilin on 2025/6/23
 */
public interface CouponInfoService extends IService<CouponInfo> {

    /**
     * 查询没有接收的优惠券
     * @param pageParam 分页参数
     * @param customerId 用户id
     * @return 没有接收的优惠券的分页结果
     */
    PageVO<NoReceiveCouponVO> findNoReceivePage(Page<CouponInfo> pageParam, Long customerId);

    /**
     * 查询顾客已经接收但没有使用的优惠券
     * @param pageParam 分页参数
     * @param customerId 顾客id
     * @return 顾客已经接收但没有使用的优惠券的分页结果
     */
    PageVO<NoUseCouponVO> findNoUsePage(Page<CouponInfo> pageParam, Long customerId);

    /**
     * 顾客接收优惠券
     * @param customerId 顾客id
     * @param couponId 优惠券id
     * @return 接收成功标示
     */
    Boolean receive(Long customerId, Long couponId);

    /**
     * 查找可用优惠券
     * @param customerId 顾客id
     * @param orderAmount 订单价钱
     * @return 可用优惠券
     */
    List<AvailableCouponVO> findAvailableCoupon(Long customerId, BigDecimal orderAmount);

    /**
     * 使用优惠券
     * @param useCouponForm 使用优惠券的表单
     * @return 使用后的订单金额
     */
    BigDecimal useCoupon(UseCouponForm useCouponForm);

    /**
     * 查询顾客已使用的优惠券
     * @param pageParam 分页参数
     * @param customerId 顾客id
     * @return 顾客已使用的优惠券的分页结果
     */
    PageVO<UsedCouponVO> findUsedPage(Page<CouponInfo> pageParam, Long customerId);
}
