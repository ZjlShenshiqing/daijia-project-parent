package com.zjl.daijia.model.entity.order;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 订单评价
 * <p>
 * Created by Zhangjilin on 2025/6/19
 */
@Data
@Schema(description = "订单评价")
@TableName("order_comment")
public class OrderComment {

    @Schema(description = "订单ID")
    @TableField("order_id")
    private Long orderId;

    @Schema(description = "司机ID")
    @TableField("driver_id")
    private Long driverId;

    @Schema(description = "顾客ID")
    @TableField("customer_id")
    private Long customerId;

    @Schema(description = "评分，1星~5星")
    @TableField("rate")
    private Integer rate;

    @Schema(description = "备注")
    @TableField("remark")
    private String remark;

    @Schema(description = "状态，1未申诉，2已申诉，3申诉失败，4申诉成功")
    @TableField("status")
    private Integer status;

    @Schema(description = "申诉工作流ID")
    @TableField("instance_id")
    private String instanceId;
}
