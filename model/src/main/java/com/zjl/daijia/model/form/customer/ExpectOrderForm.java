package com.zjl.daijia.model.form.customer;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 预估里程表单
 * <p>
 * Created by Zhangjilin on 2025/6/20
 */
@Data
public class ExpectOrderForm {

    @Schema(description = "起始地点经度")
    private BigDecimal startPointLongitude;

    @Schema(description = "起始地点纬度")
    private BigDecimal startPointLatitude;

    @Schema(description = "结束地点经度")
    private BigDecimal endPointLongitude;

    @Schema(description = "结束地点纬度")
    private BigDecimal endPointLatitude;
}
