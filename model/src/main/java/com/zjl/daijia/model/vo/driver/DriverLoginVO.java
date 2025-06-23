package com.zjl.daijia.model.vo.driver;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 驾驶员登录信息
 * <p>
 * Created by Zhangjilin on 2025/6/23
 */
@Data
public class DriverLoginVO {

    @Schema(description = "id")
    private Long id;

    @Schema(description = "微信openId")
    private String wxOpenId;

    @Schema(description = "昵称")
    private String nickname;

    @Schema(description = "性别")
    private String gender;

    @Schema(description = "头像")
    private String avatarUrl;

    @Schema(description = "是否建档人脸识别")
    private Boolean isArchiveFace;

    @Schema(description = "认证状态 0:未认证 1：审核中 2：认证通过 -1：认证未通过")
    private Integer authStatus;
}
