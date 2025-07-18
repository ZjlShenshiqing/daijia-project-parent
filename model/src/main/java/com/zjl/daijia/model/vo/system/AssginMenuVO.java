package com.zjl.daijia.model.vo.system;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * 分配菜单VO
 * <p>
 * Created by Zhangjilin on 2025/6/23
 */
@Data
@Schema(description = "分配菜单实体")
public class AssginMenuVO {

    @Schema(description = "角色id")
    private Long roleId;

    @Schema(description = "菜单id列表")
    private List<Long> menuIdList;
}
