package com.zjl.daijia.model.form.map;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 更新司机位置信息表单
 * <p>
 * Created by Zhangjilin on 2025/6/20
 */
@Data
public class UpdateDriverLocationForm {

    @Schema(description = "司机id")
    private Long driverId;

    @Schema(description = "经度")
    private BigDecimal longitude;

    @Schema(description = "纬度")
    private BigDecimal latitude;
}
