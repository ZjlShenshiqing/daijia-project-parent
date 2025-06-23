package com.zjl.daijia.model.query.system;

import lombok.Data;

/**
 * 操作日志记录
 * <p>
 * Created by Zhangjilin on 2025/6/21
 */
@Data
public class SysOperLogQuery {

    private String title;
    private String operName;

    private String createTimeBegin;
    private String createTimeEnd;
}
