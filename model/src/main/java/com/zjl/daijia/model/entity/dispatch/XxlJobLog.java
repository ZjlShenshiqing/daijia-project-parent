package com.zjl.daijia.model.entity.dispatch;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * XxlJobLog
 * <p>
 * Created by Zhangjilin on 2025/6/3
 */
@Data
@Schema(description = "XxlJobLog")
@TableName("xxl_job_log")
public class XxlJobLog {

    private static final long serialVersionUID = 1L;

    @Schema(description = "任务id")
    @TableField("job_id")
    private Long jobId;

    @Schema(description = "任务状态    0：失败    1：成功")
    @TableField("status")
    private Integer status;

    @Schema(description = "失败信息")
    @TableField("error")
    private String error;

    @Schema(description = "耗时(单位：毫秒)")
    @TableField("times")
    private Integer times;
}
