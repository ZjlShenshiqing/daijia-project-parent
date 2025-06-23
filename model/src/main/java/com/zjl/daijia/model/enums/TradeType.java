package com.zjl.daijia.model.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * 订单类别
 * <p>
 * Created by Zhangjilin on 2025/6/20
 */
@Getter
public enum TradeType {

    REWARD(1, "系统奖励"),
    ;

    @EnumValue
    private Integer type;
    private String content;

    TradeType(Integer type, String content) {
        this.type = type;
        this.content = content;
    }
}
