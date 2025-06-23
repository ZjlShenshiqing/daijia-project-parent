package com.zjl.daijia.model.form.customer;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 更换绑定手机
 * <p>
 * Created by Zhangjilin on 2025/6/20
 */
@Data
public class UpdateCustomerPhoneForm {

    @Schema(description = "客户Id")
    private Long customerId;

    @Schema(description = "手机号码")
    private String phone;

    @Schema(description = "手机验证码")
    private String code;
}
