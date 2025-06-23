package com.zjl.daijia.model.form.rules;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;

/**
 * 奖励请求表单
 * <p>
 * Created by Zhangjilin on 2025/6/21
 */
public class RewardRuleRequestForm {

    @Schema(description = "代驾时间")
    private Date startTime;

    @Schema(description = "订单个数")
    private Long orderNum;
}
