package com.zjl.daijia.model.vo.rules;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 奖励规则响应
 * <p>
 * Created by Zhangjilin on 2025/6/23
 */
@Data
public class RewardRuleResponse {

    @Schema(description = "奖励金额")
    private BigDecimal rewardAmount;
}
