package com.zjl.daijia.model.vo.customer;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 客户登录信息
 * <p>
 * Created by Zhangjilin on 2025/6/23
 */
@Data
public class CustomerLoginVO {

    @Schema(description = "微信openId")
    private String wxOpenId;

    @Schema(description = "客户昵称")
    private String nickname;

    @Schema(description = "性别")
    private String gender;

    @Schema(description = "头像")
    private String avatarUrl;

    @Schema(description = "是否绑定手机号码")
    private Boolean isBindPhone;
}
