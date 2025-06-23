package com.zjl.daijia.model.vo.order;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 当前订单信息
 * <p>
 * Created by Zhangjilin on 2025/6/23
 */
@Data
public class CurrentOrderInfoVO {

    @Schema(description = "订单id")
    private Long orderId;

    @Schema(description = "订单状态")
    private Integer status;

    @Schema(description = "当前订单信息")
    private Boolean isHasCurrentOrder;
}
