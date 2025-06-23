package com.zjl.daijia.model.vo.payment;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 微信预支付信息
 * <p>
 * Created by Zhangjilin on 2025/6/23
 */
@Data
public class WxPrepayVO {

    @Schema(description = "公众号ID")
    private String appId;

    @Schema(description = "时间戳，自1970年以来的秒数")
    private String timeStamp;

    @Schema(description = "随机串")
    private String nonceStr;

    @Schema(description = "预支付交易会话标识")
    private String packageVal;

    @Schema(description = "微信签名方式")
    private String signType;

    @Schema(description = "微信签名")
    private String paySign;
}
