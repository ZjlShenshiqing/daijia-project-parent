package com.zjl.daijia.model.form.driver;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 身份证信息
 * <p>
 * Created by Zhangjilin on 2025/6/20
 */
@Data
public class IdCardOcrForm {

    @Schema(description = "身份证Base64字符串")
    private String idCardBase64;
}
