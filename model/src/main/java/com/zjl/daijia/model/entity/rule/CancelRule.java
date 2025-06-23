package com.zjl.daijia.model.entity.rule;

import co.elastic.clients.elasticsearch.xpack.usage.Base;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zjl.daijia.model.entity.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 订单取消规则
 * <p>
 * Created by Zhangjilin on 2025/6/19
 */
@Data
@Schema(description = "订单取消规则")
@TableName("cancel_rule")
public class CancelRule extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(description = "规则名称")
    @TableField("name")
    private String name;

    @Schema(description = "规则代码")
    @TableField("rule")
    private String rule;

    @Schema(description = "状态代码，1有效，2关闭")
    @TableField("status")
    private Integer status;
}
