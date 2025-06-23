package com.zjl.daijia.model.form.system;

import lombok.Data;

/**
 * 登录表单
 * <p>
 * Created by Zhangjilin on 2025/6/20
 */
@Data
public class LoginForm {

    /**
     * 手机号
     */
    private String username;

    /**
     * 密码
     */
    private String password;
}
