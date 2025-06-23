package com.zjl.daijia.model.vo.base;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 登录的结果包装
 * <p>
 * Created by Zhangjilin on 2025/6/23
 */
public class LoginVO {

    @Schema(description = "登录用户Id")
    private Long userId;

    @Schema(description = "微信openId")
    private String wxOpenId;

    @Schema(description = "客户昵称")
    private String nickname;

    @Schema(description = "头像")
    private String avatarUrl;

}
