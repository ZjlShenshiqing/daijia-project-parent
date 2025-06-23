package com.zjl.daijia.model.entity.system;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zjl.daijia.model.entity.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 系统用户角色对应
 * <p>
 * Created by Zhangjilin on 2025/6/20
 */
@Data
@Schema(description = "用户角色")
@TableName("sys_user_role")
public class SysUserRole extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(description = "角色id")
    @TableField("role_id")
    private Long roleId;

    @Schema(description = "用户id")
    @TableField("user_id")
    private Long userId;
}
