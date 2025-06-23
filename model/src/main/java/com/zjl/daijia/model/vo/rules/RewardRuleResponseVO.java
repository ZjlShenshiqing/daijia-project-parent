package com.zjl.daijia.model.vo.rules;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 奖励规则响应VO
 * <p>
 * Created by Zhangjilin on 2025/6/23
 */
@Data
public class RewardRuleResponseVO {

    @Schema(description = "奖励规则ID")
    private Long rewardRuleId;

    @Schema(description = "奖励金额")
    private BigDecimal rewardAmount;
}
