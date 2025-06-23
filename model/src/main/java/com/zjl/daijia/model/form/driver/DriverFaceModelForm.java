package com.zjl.daijia.model.form.driver;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 司机的人脸信息
 * <p>
 * Created by Zhangjilin on 2025/6/20
 */
@Data
public class DriverFaceModelForm {

    @Schema(description = "司机id")
    private Long driverId;

    @Schema(description = "图片 base64 数据")
    private String imageBase64 ;
}
