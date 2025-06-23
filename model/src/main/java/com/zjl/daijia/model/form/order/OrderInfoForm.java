package com.zjl.daijia.model.form.order;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 订单信息表单
 * <p>
 * Created by Zhangjilin on 2025/6/21
 */
@Data
@Schema(description = "订单信息")
public class OrderInfoForm {

    @Schema(description = "客户ID")
    private Long customerId;

    @Schema(description = "订单号")
    private String orderNo;

    @Schema(description = "起始地点")
    private String startLocation;

    @Schema(description = "起始地点经度")
    private BigDecimal startPointLongitude;

    @Schema(description = "起始地点纬度")
    private BigDecimal startPointLatitude;

    @Schema(description = "结束地点")
    private String endLocation;

    @Schema(description = "结束地点经度")
    private BigDecimal endPointLongitude;

    @Schema(description = "结束地点纬度")
    private BigDecimal endPointLatitude;

    @Schema(description = "顾客小费")
    private BigDecimal favourFee;

    @Schema(description = "订单备注信息")
    private String remark;

    @Schema(description = "预估订单费用")
    private BigDecimal expectAmount;

    @Schema(description = "预估里程")
    private BigDecimal expectDistance;
}
