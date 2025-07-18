package com.zjl.daijia.model.entity.system;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zjl.daijia.model.entity.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 系统岗位信息
 * <p>
 * Created by Zhangjilin on 2025/6/20
 */
@Data
@Schema(description = "岗位")
@TableName("sys_post")
public class SysPost extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(description = "岗位编码")
    @TableField("post_code")
    private String postCode;

    @Schema(description = "岗位名称")
    @TableField("name")
    private String name;

    @Schema(description = "显示顺序")
    @TableField("description")
    private String description;

    @Schema(description = "状态（1正常 0停用）")
    @TableField("status")
    private Integer status;
}
