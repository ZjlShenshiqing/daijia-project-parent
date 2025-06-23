package com.zjl.daijia.model.vo.driver;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 文件需要上传到腾讯云时的所有元数据
 * <p>
 * Created by Zhangjilin on 2025/6/23
 */
@Data
public class CosUploadVO {

    @Schema(description = "上传路径")
    private String url;

    @Schema(description = "回显地址")
    private String showUrl;
}
