package com.zjl.daijia.model.vo.order;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单列表
 * <p>
 * Created by Zhangjilin on 2025/6/23
 */
@Data
public class OrderListVO {

    @Schema(description = "id")
    private Long id;

    @Schema(description = "订单号")
    private String orderNo;

    @Schema(description = "起始地点")
    private String startLocation;

    @Schema(description = "结束地点")
    private String endLocation;

    @Schema(description = "订单金额")
    private BigDecimal amount;

    @Schema(description = "下单时间")
    private Date createTime;

    @Schema(description = "订单状态")
    private Integer status;
}
