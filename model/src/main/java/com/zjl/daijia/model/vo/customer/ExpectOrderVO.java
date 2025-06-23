package com.zjl.daijia.model.vo.customer;

import com.zjl.daijia.model.vo.map.DrivingLineVO;
import com.zjl.daijia.model.vo.rules.FeeRuleResponseVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 预订单信息
 * <p>
 * Created by Zhangjilin on 2025/6/23
 */
@Data
@Schema(description = "预计订单实体")
public class ExpectOrderVO {

    @Schema(description = "驾车路线")
    private DrivingLineVO drivingLineVo;

    @Schema(description = "订单费用")
    private FeeRuleResponseVO feeRuleResponseVo;
}
