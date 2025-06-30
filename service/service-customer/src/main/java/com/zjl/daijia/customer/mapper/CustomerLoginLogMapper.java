package com.zjl.daijia.customer.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zjl.daijia.model.entity.customer.CustomerInfo;
import com.zjl.daijia.model.entity.customer.CustomerLoginLog;
import org.apache.ibatis.annotations.Mapper;

/**
 * 顾客登录日志数据库交互层
 * <p>
 * Created by Zhangjilin on 2025/6/30
 */
@Mapper
public interface CustomerLoginLogMapper extends BaseMapper<CustomerLoginLog> {
}
