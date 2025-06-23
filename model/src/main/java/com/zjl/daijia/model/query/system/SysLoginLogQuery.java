package com.zjl.daijia.model.query.system;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 登录信息查询
 * <p>
 * Created by Zhangjilin on 2025/6/21
 */
public class SysLoginLogQuery {

    @Schema(description = "用户账号")
    private String username;

    private String createTimeBegin;
    private String createTimeEnd;
}
