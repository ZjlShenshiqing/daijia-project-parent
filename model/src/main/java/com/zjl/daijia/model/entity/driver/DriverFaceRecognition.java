package com.zjl.daijia.model.entity.driver;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zjl.daijia.model.entity.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

/**
 * 司机人脸扫描上岗
 * <p>
 * Created by Zhangjilin on 2025/6/3
 */
@Data
@Schema(description = "司机人脸扫描上岗")
@TableName("driver_face_recognition")
public class DriverFaceRecognition extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(description = "司机id")
    @TableField("driver_id")
    private Long driverId;

    @Schema(description = "识别日期")
    @TableField("face_date")
    private Date faceDate;
}
