package com.zjl.daijia.model.entity.payment;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 具体的分账详情
 * <p>
 * Created by Zhangjilin on 2025/6/19
 */
@Data
@Schema(description = "支付分账详情")
@TableName("profitsharing_info")
public class ProfitsharingInfo {

    private static final long serialVersionUID = 1L;

    @Schema(description = "司机id")
    @TableField("driver_id")
    private Long driverId;

    @Schema(description = "订单号")
    @TableField("order_no")
    private String orderNo;

    @Schema(description = "微信支付订单号")
    @TableField("transaction_id")
    private String transactionId;

    @Schema(description = "商户分账单号")
    @TableField("out_trade_no")
    private String outTradeNo;

    @Schema(description = "司机分账金额")
    @TableField("amount")
    private String amount;

    @Schema(description = "分账单状态 PROCESSING：处理中  FINISHED：分账完成")
    @TableField("state")
    private String state;

    @Schema(description = "返回信息")
    @TableField("respone_content")
    private String responeContent;
}
