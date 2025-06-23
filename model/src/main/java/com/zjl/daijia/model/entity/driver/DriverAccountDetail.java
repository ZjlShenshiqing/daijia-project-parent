package com.zjl.daijia.model.entity.driver;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zjl.daijia.model.entity.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 账户具体支出
 * <p>
 * Created by Zhangjilin on 2025/6/3
 */
@Data
@Schema(description = "账户具体支出")
@TableName("driver_account_detail")
public class DriverAccountDetail extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(description = "司机ID")
    @TableField("driver_id")
    private Long driverId;

    @Schema(description = "交易具体内容")
    @TableField("content")
    private String content;

    @Schema(description = "交易类型：1201-充值 1202-锁定 1203-解锁 1204-消费")
    @TableField("trade_type")
    private String tradeType;

    @Schema(description = "交易金额")
    @TableField("amount")
    private BigDecimal amount;

    @Schema(description = "交易号")
    @TableField("trade_no")
    private String tradeNo;
}
