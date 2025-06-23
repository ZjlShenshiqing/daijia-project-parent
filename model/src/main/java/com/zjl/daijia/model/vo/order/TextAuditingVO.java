package com.zjl.daijia.model.vo.order;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 文本审核
 * <p>
 * Created by Zhangjilin on 2025/6/23
 */
@Data
public class TextAuditingVO {

    @Schema(description = "审核结果")
    private String result;

    @Schema(description = "风险关键词")
    private String keywords;
}
