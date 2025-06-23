package com.zjl.daijia.model.vo.map;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 最近的司机
 * <p>
 * Created by Zhangjilin on 2025/6/23
 */
@Data
public class NearByDriverVO {

    @Schema(description = "司机id")
    private Long driverId;

    @Schema(description = "距离")
    private BigDecimal distance;
}
