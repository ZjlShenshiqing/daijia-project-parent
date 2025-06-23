package com.zjl.daijia.model.query.system;

import lombok.Data;

/**
 * 岗位信息
 * <p>
 * Created by Zhangjilin on 2025/6/21
 */
@Data
public class SysPostQuery {

    //@Schema(description = "岗位编码")
    private String postCode;

    //@Schema(description = "岗位名称")
    private String name;

    //@Schema(description = "状态（1正常 0停用）")
    private Boolean status;
}
