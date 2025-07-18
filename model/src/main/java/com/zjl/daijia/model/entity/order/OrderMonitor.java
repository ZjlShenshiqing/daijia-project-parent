package com.zjl.daijia.model.entity.order;

import co.elastic.clients.elasticsearch.xpack.usage.Base;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zjl.daijia.model.entity.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 订单监控
 * <p>
 * Created by Zhangjilin on 2025/6/19
 */
@Data
@Schema(description = "订单监控")
@TableName("order_monitor")
public class OrderMonitor extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(description = "订单ID")
    @TableField("order_id")
    private Long orderId;

    @Schema(description = "文件个数")
    @TableField("file_num")
    private Integer fileNum;

    @Schema(description = "需要审核的个数")
    @TableField("audit_num")
    private Integer auditNum;

    @Schema(description = "是否报警")
    @TableField("is_alarm")
    private Integer isAlarm;

    @Schema(description = "状态")
    @TableField("status")
    private Integer status;
}
