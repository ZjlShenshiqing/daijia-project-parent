package com.zjl.daijia.model.entity.system;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zjl.daijia.model.entity.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * 部门
 * <p>
 * Created by Zhangjilin on 2025/6/19
 */
@Data
@Schema(description = "部门")
@TableName("sys_dept")
public class SysDept extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(description = "部门名称")
    @TableField("name")
    private String name;

    @Schema(description = "上级部门id")
    @TableField("parent_id")
    private Long parentId;

    @Schema(description = "树结构")
    @TableField("tree_path")
    private String treePath;

    @Schema(description = "排序")
    @TableField("sort_value")
    private Integer sortValue;

    @Schema(description = "负责人")
    @TableField("leader")
    private String leader;

    @Schema(description = "电话")
    @TableField("phone")
    private String phone;

    @Schema(description = "状态（1正常 0停用）")
    @TableField("status")
    private Integer status;

    @Schema(description = "下级部门")
    @TableField(exist = false)
    private List<SysDept> children;
}
