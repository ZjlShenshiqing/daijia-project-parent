package com.zjl.daijia.model.entity.order;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zjl.daijia.model.entity.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

/**
 * 订单状态
 * <p>
 * Created by Zhangjilin on 2025/6/19
 */
@Data
@Schema(description = "订单状态")
@TableName("order_status_log")
public class OrderStatusLog extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(description = "orderId")
    @TableField("order_id")
    private Long orderId;

    @Schema(description = "订单状态")
    @TableField("order_status")
    private Integer orderStatus;

    @Schema(description = "操作时间")
    @TableField("operate_time")
    private Date operateTime;
}
