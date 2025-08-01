package com.zjl.daijia.model.entity.coupon;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zjl.daijia.model.entity.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

/**
 * 乘客使用的优惠券信息
 * <p>
 * Created by Zhangjilin on 2025/6/1
 */
@Data
@Schema(description = "乘客使用的优惠券信息")
@TableName("customer_coupon")
public class CustomerCoupon extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(description = "优惠券ID")
    @TableField("coupon_id")
    private Long couponId;

    @Schema(description = "乘客ID")
    @TableField("customer_id")
    private Long customerId;

    @Schema(description = "购物券状态（1：未使用 2：已使用）")
    @TableField("status")
    private Integer status;

    @Schema(description = "领取时间")
    @TableField("receive_time")
    private Date receiveTime;

    @Schema(description = "使用时间")
    @TableField("used_time")
    private Date usedTime;

    @Schema(description = "订单id")
    @TableField("order_id")
    private Long orderId;

    @Schema(description = "过期时间")
    @TableField("expire_time")
    private Date expireTime;
}
