package com.zjl.daijia.model.form.customer;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 乘客信息更新
 * <p>
 * Created by Zhangjilin on 2025/6/20
 */
public class UpdateCustomerInfoForm {

    @Schema(description = "客户Id")
    private Long customerId;

    @Schema(description = "客户昵称")
    private String nickname;

    @Schema(description = "性别")
    private String gender;

    @Schema(description = "头像")
    private String avatarUrl;
}
