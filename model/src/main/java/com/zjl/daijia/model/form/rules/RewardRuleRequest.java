package com.zjl.daijia.model.form.rules;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 奖励规则请求
 * <p>
 * Created by Zhangjilin on 2025/6/21
 */
@Data
public class RewardRuleRequest {

    @Schema(description = "代驾时间")
    private String startTime;

    @Schema(description = "订单个数")
    private Long orderNum;
}
