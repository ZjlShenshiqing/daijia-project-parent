package com.zjl.daijia.model.entity.order;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zjl.daijia.model.entity.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 订单实时状态追踪
 * <p>
 * Created by Zhangjilin on 2025/6/19
 */
@Data
@Schema(description = "订单实时状态追踪")
@TableName("order_track")
public class OrderTrack extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(description = "订单id")
    @TableField("order_id")
    private Long orderId;

    @Schema(description = "司机id")
    @TableField("driver_id")
    private Long driverId;

    @Schema(description = "客户id")
    @TableField("customer_id")
    private Long customerId;

    @Schema(description = "经度")
    @TableField("longitude")
    private String longitude;

    @Schema(description = "纬度")
    @TableField("latitude")
    private String latitude;

    @Schema(description = "速度")
    @TableField("speed")
    private String speed;
}
