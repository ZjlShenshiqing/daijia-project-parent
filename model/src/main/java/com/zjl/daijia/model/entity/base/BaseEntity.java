package com.zjl.daijia.model.entity.base;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 底层实体类 (实体类的通用部分)
 * <p>
 * Created by Zhangjilin on 2025/5/31
 */
@Data
public class BaseEntity implements Serializable {

    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @JsonIgnore
    @TableField("update_time")
    private Date updateTime;

    /**
     * 逻辑删除
     * 删除这条记录时，不是真的从数据库删除，而是把is_deleted改成一个标记值
     */
    @JsonIgnore
    @TableLogic
    @TableField("is_deleted")
    private Integer isDeleted;

    /**
     * 临时参数容器
     */
    @JsonIgnore
    @TableField(exist = false)
    private Map<String,Object> param = new HashMap<>();
}
