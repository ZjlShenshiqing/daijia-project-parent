package com.zjl.daijia.model.form.driver;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 更新司机电话号码
 * <p>
 * Created by Zhangjilin on 2025/6/20
 */
public class UpdateDriverPhoneForm {

    @Schema(description = "司机Id")
    private Long driverId;


    @Schema(description = "手机号码")
    private String phone;
}
