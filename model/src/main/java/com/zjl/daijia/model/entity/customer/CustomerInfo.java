package com.zjl.daijia.model.entity.customer;

import com.zjl.daijia.model.entity.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 客户信息实体类
 * <p>
 * Created by Zhangjilin on 2025/6/3
 */
@Data
@Schema(description = "客户信息实体类")
public class CustomerInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(description = "微信openId")
    private String wxOpenId;

    @Schema(description = "客户昵称")
    private String nickname;

    @Schema(description = "性别")
    private String gender;

    @Schema(description = "头像")
    private String avatarUrl;

    @Schema(description = "电话")
    private String phone;

    @Schema(description = "1有效，2禁用")
    private Integer status;
}
