package com.zjl.daijia.model.entity.order;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 订单风险记录
 * <p>
 * Created by Zhangjilin on 2025/6/19
 */
@Data
@Schema(description = "订单风险记录")
@Document("order_monitor_record")
public class OrderMonitorRecord {

    @Schema(description = "id")
    @Id
    private String id;

    @Schema(description = "订单ID")
    private Long orderId;

    @Schema(description = "文件路径")
    private String fileUrl;

    @Schema(description = "内容")
    private String content;

    @Schema(description = "审核结果")
    private String result;

    @Schema(description = "风险关键词")
    private String keywords;

    @Schema(description = "状态")
    private Integer status;
}
