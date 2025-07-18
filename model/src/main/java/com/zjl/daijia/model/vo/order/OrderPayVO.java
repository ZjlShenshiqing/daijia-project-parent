package com.zjl.daijia.model.vo.order;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

/**
 * 订单支付信息
 * <p>
 * Created by Zhangjilin on 2025/6/23
 */
public class OrderPayVO {

    @Schema(description = "订单id")
    private Long orderId;

    @Schema(description = "乘客id")
    private Long customerId;

    @Schema(description = "司机id")
    private Long driverId;

    @Schema(description = "订单号")
    private String orderNo;

    @Schema(description = "支付金额")
    private BigDecimal payAmount;

    @Schema(description = "使用的优惠券金额")
    private BigDecimal couponAmount;

    @Schema(description = "起始地点")
    private String startLocation;

    @Schema(description = "结束地点")
    private String endLocation;

    @Schema(description = "交易内容")
    private String content;

    @Schema(description = "订单状态")
    private Integer status;

}
