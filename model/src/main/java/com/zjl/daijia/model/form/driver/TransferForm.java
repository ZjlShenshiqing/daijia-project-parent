package com.zjl.daijia.model.form.driver;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 转账表单
 * <p>
 * Created by Zhangjilin on 2025/6/20
 */
@Data
public class TransferForm {

    @Schema(description = "身份证Base64字符串")
    private Long driverId;

    @Schema(description = "交易内容")
    private String content;

    @Schema(description = "交易类型")
    private Integer tradeType;

    @Schema(description = "交易金额")
    private BigDecimal amount;

    @Schema(description = "交易编号")
    private String tradeNo;
}
