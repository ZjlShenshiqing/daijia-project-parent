package com.zjl.daijia.model.vo.system;

/**
 * 登录对象实体
 * <p>
 * Created by Zhangjilin on 2025/6/23
 */
public class LoginVO {

    /**
     * 手机号
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
