package com.zjl.daijia.coupon.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zjl.daijia.model.entity.coupon.CouponInfo;
import com.zjl.daijia.model.vo.coupon.NoReceiveCouponVO;
import com.zjl.daijia.model.vo.coupon.NoUseCouponVO;
import com.zjl.daijia.model.vo.coupon.UsedCouponVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * 优惠券信息数据库交互层
 * <p>
 * Created by Zhangjilin on 2025/6/23
 */
@Mapper
public interface CouponInfoMapper extends BaseMapper<CouponInfo> {

    /**
     * 分页查询未领取优惠券
     * @param pageParam 分页参数
     * @param customerId 用户id
     * @return 未领取优惠券分页结果
     */
    IPage<NoReceiveCouponVO> findNoReceivePage(Page<CouponInfo> pageParam, @Param("customerId") Long customerId);

    /**
     * 分页查询未使用优惠券
     * @param pageParam 分页参数
     * @param customerId 用户id
     * @return 未使用优惠券的分页结果
     */
    IPage<NoUseCouponVO> findNoUsePage(Page<CouponInfo> pageParam, @Param("customerId") Long customerId);

    /**
     * 更新优惠券领取次数
     * @param couponId 优惠券id
     * @return 更新结果
     */
    int updateReceiveCount(Long couponId);

    /**
     * 查询乘客已领取但没有使用的优惠券列表
     * @param customerId 用户id
     * @return 已领取但未使用的优惠券列表
     */
    List<NoUseCouponVO> findNoUseList(@Param("customerId") Long customerId);

    /**
     * 分页查询已使用优惠券
     * @param pageParam 分页参数
     * @param customerId 用户id
     * @return 已使用优惠券的分页结果
     */
    IPage<UsedCouponVO> findUsedPage(Page<CouponInfo> pageParam, Long customerId);

}
