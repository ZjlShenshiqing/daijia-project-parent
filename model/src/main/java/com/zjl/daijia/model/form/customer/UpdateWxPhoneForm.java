package com.zjl.daijia.model.form.customer;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 更换微信的手机号
 * <p>
 * Created by Zhangjilin on 2025/6/20
 */
public class UpdateWxPhoneForm {

    @Schema(description = "客户Id")
    private Long customerId;

    private String code;
}
