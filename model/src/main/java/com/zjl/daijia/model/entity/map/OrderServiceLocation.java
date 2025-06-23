package com.zjl.daijia.model.entity.map;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单服务位置
 * <p>
 * Created by Zhangjilin on 2025/6/19
 */
@Data
@Schema(description = "订单服务位置")
@Document
public class OrderServiceLocation {

    @Schema(description = "id")
    @Id
    private String id;

    @Schema(description = "订单id")
    private Long orderId;

    @Schema(description = "经度")
    private BigDecimal latitude;

    @Schema(description = "纬度")
    private BigDecimal longitude;

    @Schema(description = "创建时间")
    private Date createTime;
}
