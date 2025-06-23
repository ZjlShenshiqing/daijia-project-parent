package com.zjl.daijia.model.form.payment;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

/**
 * ProfitsharingForm
 * <p>
 * Created by Zhangjilin on 2025/6/21
 */
@Data
public class ProfitsharingForm {

    @Schema(description = "身份证Base64字符串")
    private Long driverId;

    @Schema(description = "订单号")
    private String orderNo;

    @Schema(description = "分账金额")
    private BigDecimal amount;
}
