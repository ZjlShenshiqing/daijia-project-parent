package com.zjl.daijia.model.vo.coupon;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

/**
 * 未收到的优惠券
 * <p>
 * Created by Zhangjilin on 2025/6/23
 */
@Data
@Schema(description = "没有收到的优惠卷")
public class NoReceiveCouponVO {

    private Long id;

    @Schema(description = "优惠卷类型 1 现金券 2 折扣")
    private Integer couponType;

    @Schema(description = "优惠卷名字")
    private String name;

    @Schema(description = "金额")
    private String amount;

    @Schema(description = "折扣：取值[1 到 10]")
    private String discount;

    @Schema(description = "使用门槛 0->没门槛")
    private String conditionAmount;

    @Schema(description = "发行数量")
    private Integer publishCount;

    @Schema(description = "每人限领张数")
    private Integer perLimit;

    @Schema(description = "过期时间")
    private Date expireTime;

    @Schema(description = "优惠券描述")
    private String description;
}
