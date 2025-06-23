package com.zjl.daijia.model.form.rules;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 订单费用规则请求
 * <p>
 * Created by Zhangjilin on 2025/6/21
 */
@Data
public class FeeRuleRequest {

    @Schema(description = "代驾里程")
    private BigDecimal distance;

    @Schema(description = "代驾时间")
    private String startTime;

    @Schema(description = "等候分钟")
    private Integer waitMinute;
}
