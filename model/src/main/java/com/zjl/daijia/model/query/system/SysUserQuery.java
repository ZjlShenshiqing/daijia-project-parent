package com.zjl.daijia.model.query.system;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户查询
 * <p>
 * Created by Zhangjilin on 2025/6/21
 */
@Data
public class SysUserQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    private String keyword;

    private String createTimeBegin;
    private String createTimeEnd;

    private Long roleId;
    private Long postId;
    private Long deptId;
}
