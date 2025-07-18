package com.zjl.daijia.model.vo.coupon;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 可用优惠券
 * <p>
 * Created by Zhangjilin on 2025/6/23
 */
@Data
@Schema(description = "可用优惠券")
public class AvailableCouponVO {

    @Schema(description = "优惠券id")
    private Long couponId;

    @Schema(description = "优惠卷类型 1 现金券 2 折扣")
    private Integer couponType;

    @Schema(description = "优惠卷名字")
    private String name;

    @Schema(description = "金额")
    private BigDecimal amount;

    @Schema(description = "折扣：取值[1 到 10]")
    private BigDecimal discount;

    @Schema(description = "使用门槛 0->没门槛")
    private BigDecimal conditionAmount;

    @Schema(description = "发行数量")
    private Integer publishCount;

    @Schema(description = "每人限领张数")
    private Integer perLimit;

    @Schema(description = "过期时间")
    private Date expireTime;

    @Schema(description = "优惠券描述")
    private String description;

    @Schema(description = "乘客优惠券id")
    private Long customerCouponId;

    @Schema(description = "领取时间")
    private Date receiveTime;

    @Schema(description = "减免金额")
    private BigDecimal reduceAmount;
}
