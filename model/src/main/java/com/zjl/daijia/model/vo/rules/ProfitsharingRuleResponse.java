package com.zjl.daijia.model.vo.rules;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 分账规则响应
 * <p>
 * Created by Zhangjilin on 2025/6/23
 */
@Data
public class ProfitsharingRuleResponse {

    @Schema(description = "订单金额")
    private BigDecimal orderAmount;

    @Schema(description = "微信支付平台费率")
    private BigDecimal paymentRate;

    @Schema(description = "微信支付平台费用")
    private BigDecimal paymentFee;

    @Schema(description = "代驾司机代缴个税税率")
    private BigDecimal driverTaxRate;

    @Schema(description = "代驾司机税率支出费用")
    private BigDecimal driverTaxFee;

    @Schema(description = "平台分账收入")
    private BigDecimal platformIncome;

    @Schema(description = "司机分账收入")
    private BigDecimal driverIncome;
}
