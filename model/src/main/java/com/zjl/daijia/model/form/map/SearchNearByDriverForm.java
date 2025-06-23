package com.zjl.daijia.model.form.map;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 搜寻最近的乘客表单
 * <p>
 * Created by Zhangjilin on 2025/6/20
 */
@Data
public class SearchNearByDriverForm {

    @Schema(description = "经度")
    private BigDecimal longitude;

    @Schema(description = "纬度")
    private BigDecimal latitude;

    @Schema(description = "距离多远")
    private BigDecimal mileageDistance;

}
