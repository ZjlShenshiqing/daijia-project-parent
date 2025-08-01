package com.zjl.daijia.model.entity.driver;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zjl.daijia.model.entity.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 司机接单功能设置
 * <p>
 * Created by Zhangjilin on 2025/6/17
 */
@Data
@Schema(description = "司机接单设置")
@TableName("driver_set")
public class DriverSet extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(description = "司机ID")
    @TableField("driver_id")
    private Long driverId;

    @Schema(description = "服务状态 1：开始接单 0：未接单")
    @TableField("service_status")
    private Integer serviceStatus;

    @Schema(description = "订单里程设置")
    @TableField("order_distance")
    private BigDecimal orderDistance;

    @Schema(description = "接单里程设置")
    @TableField("accept_distance")
    private BigDecimal acceptDistance;

    @Schema(description = "是否自动接单")
    @TableField("is_auto_accept")
    private Integer isAutoAccept;
}
