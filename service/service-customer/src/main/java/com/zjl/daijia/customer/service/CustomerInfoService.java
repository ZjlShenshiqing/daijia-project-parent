package com.zjl.daijia.customer.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zjl.daijia.model.entity.customer.CustomerInfo;
import com.zjl.daijia.model.form.customer.UpdateWxPhoneForm;
import com.zjl.daijia.model.vo.customer.CustomerLoginVO;

/**
 * 客户详细信息服务服务层
 * <p>
 * Created by Zhangjilin on 2025/6/30
 */
public interface CustomerInfoService extends IService<CustomerInfo> {

    /**
     * 微信小程序登录接口
     */
    Long login(String code);

    /**
     * 获取客户登录信息
     */
    CustomerLoginVO getCustomerInfo(Long customerId);

    /**
     * 更新客户微信手机号码
     */
    Boolean updateWxPhoneNumber(UpdateWxPhoneForm updateWxPhoneForm);

    /**
     * 获取客户OpenId
     */
    String getCustomerOpenId(Long customerId);
}
