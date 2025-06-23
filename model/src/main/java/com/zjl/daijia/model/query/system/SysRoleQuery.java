package com.zjl.daijia.model.query.system;

import java.io.Serializable;

/**
 * 角色查询实体
 * <p>
 * Created by Zhangjilin on 2025/6/21
 */
public class SysRoleQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    private String roleName;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
