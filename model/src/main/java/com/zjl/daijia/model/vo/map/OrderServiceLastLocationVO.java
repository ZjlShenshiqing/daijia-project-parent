package com.zjl.daijia.model.vo.map;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 最近的订单位置
 * <p>
 * Created by Zhangjilin on 2025/6/23
 */
@Data
public class OrderServiceLastLocationVO {

    @Schema(description = "经度")
    private BigDecimal longitude;

    @Schema(description = "纬度")
    private BigDecimal latitude;
}
