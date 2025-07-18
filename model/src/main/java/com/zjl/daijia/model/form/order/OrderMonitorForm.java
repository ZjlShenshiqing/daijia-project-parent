package com.zjl.daijia.model.form.order;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 订单监控
 * <p>
 * Created by Zhangjilin on 2025/6/21
 */
@Data
@Schema(description = "订单监控")
public class OrderMonitorForm {

    @Schema(description = "订单ID")
    private Long orderId;

    @Schema(description = "监控内容")
    private String content;
}
