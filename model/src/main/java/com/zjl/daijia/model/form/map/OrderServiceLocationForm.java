package com.zjl.daijia.model.form.map;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 地点服务起始地点
 * <p>
 * Created by Zhangjilin on 2025/6/20
 */
@Data
public class OrderServiceLocationForm {

    @Schema(description = "订单id")
    private Long orderId;

    @Schema(description = "经度")
    private BigDecimal longitude;

    @Schema(description = "纬度")
    private BigDecimal latitude;

}
