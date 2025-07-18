package com.zjl.daijia.model.form.order;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 订单评论表单
 * <p>
 * Created by Zhangjilin on 2025/6/21
 */
@Data
@Schema(description = "订单评论")
public class OrderCommentForm {

    @Schema(description = "订单ID")
    private Long orderId;

    @Schema(description = "司机ID")
    private Long driverId;

    @Schema(description = "顾客ID")
    private Long customerId;

    @Schema(description = "评分，1星~5星")
    private Integer rate;

    @Schema(description = "差评备注")
    private String remark;
}
