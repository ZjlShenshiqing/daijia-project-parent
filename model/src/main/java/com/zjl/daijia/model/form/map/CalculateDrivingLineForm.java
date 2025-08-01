package com.zjl.daijia.model.form.map;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 计算行车轨迹表单
 * <p>
 * Created by Zhangjilin on 2025/6/20
 */
@Data
public class CalculateDrivingLineForm {

    @Schema(description = "起始地点经度")
    private BigDecimal startPointLongitude;

    @Schema(description = "起始地点纬度")
    private BigDecimal startPointLatitude;

    @Schema(description = "结束地点经度")
    private BigDecimal endPointLongitude;

    @Schema(description = "结束地点纬度")
    private BigDecimal endPointLatitude;
}
