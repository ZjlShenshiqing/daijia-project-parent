package com.zjl.daijia.coupon.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zjl.daijia.model.entity.coupon.CustomerCoupon;
import org.apache.ibatis.annotations.Mapper;

/**
 * 乘客优惠券数据交互
 * <p>
 * Created by Zhangjilin on 2025/6/23
 */
@Mapper
public interface CustomerCouponMapper extends BaseMapper<CustomerCoupon> {
}
