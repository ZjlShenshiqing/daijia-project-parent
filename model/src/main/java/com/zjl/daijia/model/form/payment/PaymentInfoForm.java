package com.zjl.daijia.model.form.payment;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 支付订单的信息表单
 * <p>
 * Created by Zhangjilin on 2025/6/21
 */
@Data
public class PaymentInfoForm {

    @Schema(description = "乘客微信openid")
    private String customerOpenId;

    @Schema(description = "司机微信openid")
    private String driverOpenId;

    @Schema(description = "订单号")
    private String orderNo;

    @Schema(description = "付款方式：1-微信")
    private Integer payWay;

    @Schema(description = "支付金额")
    private BigDecimal amount;

    @Schema(description = "交易内容")
    private String content;
}
