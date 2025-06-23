package com.zjl.daijia.model.form.order;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 开始代驾订单
 * <p>
 * Created by Zhangjilin on 2025/6/21
 */
@Data
@Schema(description = "开始代驾订单")
public class StartDriveForm {

    @Schema(description = "订单ID")
    private Long orderId;

    @Schema(description = "司机ID")
    private Long driverId;
}
