package com.zjl.daijia.model.entity.driver;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zjl.daijia.model.entity.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 司机账号
 * <p>
 * Created by Zhangjilin on 2025/6/3
 */
@Data
@Schema(description = "司机账号")
@TableName("driver_account")
public class DriverAccount extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(description = "司机ID")
    @TableField("driver_id")
    private Long driverId;

    @Schema(description = "账户总金额")
    @TableField("total_amount")
    private BigDecimal totalAmount;

    @Schema(description = "锁定金额")
    @TableField("lock_amount")
    private BigDecimal lockAmount;

    @Schema(description = "可用金额")
    @TableField("available_amount")
    private BigDecimal availableAmount;

    @Schema(description = "总收入")
    @TableField("total_income_amount")
    private BigDecimal totalIncomeAmount;

    @Schema(description = "总支出")
    @TableField("total_pay_amount")
    private BigDecimal totalPayAmount;
}
