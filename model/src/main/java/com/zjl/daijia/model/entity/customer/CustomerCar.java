package com.zjl.daijia.model.entity.customer;

import co.elastic.clients.elasticsearch.xpack.usage.Base;
import com.zjl.daijia.model.entity.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 乘客自己的车，因为要让别人代驾
 * <p>
 * Created by Zhangjilin on 2025/6/1
 */
@Data
@Schema(description = "CustomerCar")
public class CustomerCar extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(description = "客户ID")
    private Long customerId;

    @Schema(description = "车牌号")
    private String license;

    @Schema(description = "车型")
    private String brand;
}
