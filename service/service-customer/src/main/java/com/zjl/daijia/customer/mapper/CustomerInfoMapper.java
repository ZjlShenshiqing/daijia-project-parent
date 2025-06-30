package com.zjl.daijia.customer.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zjl.daijia.model.entity.customer.CustomerInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * 顾客信息与数据库交互层
 * <p>
 * Created by Zhangjilin on 2025/6/30
 */
@Mapper
public interface CustomerInfoMapper extends BaseMapper<CustomerInfo> {
}
