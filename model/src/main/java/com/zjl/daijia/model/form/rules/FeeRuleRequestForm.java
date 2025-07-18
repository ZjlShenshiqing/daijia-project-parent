package com.zjl.daijia.model.form.rules;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单费用规则请求表单
 * <p>
 * Created by Zhangjilin on 2025/6/21
 */
@Data
public class FeeRuleRequestForm {

    @Schema(description = "代驾里程")
    private BigDecimal distance;

    @Schema(description = "代驾时间")
    private Date startTime;

    @Schema(description = "等候分钟")
    private Integer waitMinute;
}
