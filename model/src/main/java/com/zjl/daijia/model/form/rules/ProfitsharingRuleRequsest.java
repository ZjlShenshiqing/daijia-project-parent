package com.zjl.daijia.model.form.rules;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 奖励规则请求
 * <p>
 * Created by Zhangjilin on 2025/6/21
 */
@Data
public class ProfitsharingRuleRequsest {

    @Schema(description = "订单金额")
    private BigDecimal orderAmount;

    @Schema(description = "当天完成订单个数")
    private Long orderNum;
}
