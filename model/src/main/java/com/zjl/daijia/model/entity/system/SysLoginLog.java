package com.zjl.daijia.model.entity.system;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

/**
 * 用户登录信息日志记录
 * <p>
 * Created by Zhangjilin on 2025/6/19
 */
@Data
@Schema(description = "SysLoginLog")
@TableName("sys_login_log")
public class SysLoginLog {

    private static final long serialVersionUID = 1L;

    @Schema(description = "用户账号")
    @TableField("username")
    private String username;

    @Schema(description = "登录IP地址")
    @TableField("ipaddr")
    private String ipaddr;

    @Schema(description = "登录状态（0成功 1失败）")
    @TableField("status")
    private Integer status;

    @Schema(description = "提示信息")
    @TableField("msg")
    private String msg;

    @Schema(description = "访问时间")
    @TableField("access_time")
    private Date accessTime;
}
