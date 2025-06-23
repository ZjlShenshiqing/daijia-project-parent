package com.zjl.daijia.model.entity.customer;

import com.zjl.daijia.model.entity.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 客户登录信息
 * <p>
 * Created by Zhangjilin on 2025/6/3
 */
@Data
@Schema(description = "客户登录信息")
public class CustomerLoginLog extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(description = "客户ID")
    private Long customerId;

    @Schema(description = "登录IP地址")
    private String ipaddr;

    @Schema(description = "登录状态（0成功 1失败）")
    private Boolean status;

    @Schema(description = "提示信息")
    private String msg;

}
