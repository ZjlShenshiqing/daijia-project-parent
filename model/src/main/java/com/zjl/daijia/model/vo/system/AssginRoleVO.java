package com.zjl.daijia.model.vo.system;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * 分配角色实体
 * <p>
 * Created by Zhangjilin on 2025/6/23
 */
@Data
@Schema(description = "分配菜单")
public class AssginRoleVO {

    @Schema(description = "用户id")
    private Long userId;

    @Schema(description = "角色id列表")
    private List<Long> roleIdList;
}
