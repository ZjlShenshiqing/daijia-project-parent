package com.zjl.daijia.customer.service.Impl;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import cn.binarywang.wx.miniapp.bean.WxMaPhoneNumberInfo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zjl.daijia.common.exception.BusinessException;
import com.zjl.daijia.common.result.ResultCodeEnum;
import com.zjl.daijia.customer.mapper.CustomerInfoMapper;
import com.zjl.daijia.customer.mapper.CustomerLoginLogMapper;
import com.zjl.daijia.customer.service.CustomerInfoService;
import com.zjl.daijia.model.entity.customer.CustomerInfo;
import com.zjl.daijia.model.entity.customer.CustomerLoginLog;
import com.zjl.daijia.model.form.customer.UpdateWxPhoneForm;
import com.zjl.daijia.model.vo.customer.CustomerLoginVO;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * 客户详细信息服务服务层实现类
 * <p>
 * Created by Zhangjilin on 2025/6/30
 */
@Slf4j
@Service
@SuppressWarnings({"unchecked", "rawtypes"})
public class CustomerInfoServiceImpl extends ServiceImpl<CustomerInfoMapper, CustomerInfo> implements CustomerInfoService {

    @Resource
    private WxMaService wxMaService;

    @Resource
    private CustomerInfoMapper customerInfoMapper;

    @Resource
    private CustomerLoginLogMapper customerLoginLogMapper;

    /**
     * 微信小程序登录接口
     */
    @Override
    public Long login(String code) {
        // 获取code值
        String openid = null;
        try {
            // 拿着前端的 code，去请求微信服务器的 jscode2session 接口，获取这个用户的 openid（唯一标识）和 session_key（会话密钥）。
            WxMaJscode2SessionResult sessionInfo = wxMaService.getUserService().getSessionInfo(code);
            openid = sessionInfo.getOpenid();
        } catch (WxErrorException e) {
            throw new RuntimeException(e);
        }

        // 通过 openid 查询数据库表，判断是否是第一次登录
        // 如果openid不存在返回null，如果存在返回一条记录  select * from customer_info ci where ci.wx_open_id = ''
        LambdaQueryWrapper<CustomerInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(CustomerInfo::getWxOpenId, openid);
        CustomerInfo customerInfo = customerInfoMapper.selectOne(queryWrapper);

        // 若是第一次登录，添加信息到用户表
        if (customerInfo == null) {
            customerInfo = new CustomerInfo();
            customerInfo.setNickname(String.valueOf(System.currentTimeMillis()));
            customerInfo.setAvatarUrl("https://oss.aliyuncs.com/aliyun_id_photo_bucket/default_handsome.jpg");
            customerInfo.setWxOpenId(openid);
            customerInfoMapper.insert(customerInfo);
        }

        // 记录登录日志
        CustomerLoginLog customerLoginLog = new CustomerLoginLog();
        customerLoginLog.setCustomerId(customerInfo.getId());
        customerLoginLog.setMsg("小程序登录");
        customerLoginLogMapper.insert(customerLoginLog);

        // 返回用户id
        return customerInfo.getId();
    }

    /**
     * 获取客户登录信息
     */
    @Override
    public CustomerLoginVO getCustomerInfo(Long customerId) {
        // 根据用户id查询用户信息
        CustomerInfo customerInfo = customerInfoMapper.selectById(customerId);

        // 封装成CustomerLoginVO
        CustomerLoginVO customerLoginVO = new CustomerLoginVO();
        BeanUtils.copyProperties(customerInfo, customerLoginVO);

        // 判断是否绑定了手机号码
        String phone = customerInfo.getPhone();
        boolean isBindPhone = StringUtils.hasText(phone);
        customerLoginVO.setIsBindPhone(isBindPhone);

        // CustomerLoginVo返回
        return customerLoginVO;
    }

    /**
     * 更新客户微信手机号码
     */
    @Override
    public Boolean updateWxPhoneNumber(UpdateWxPhoneForm updateWxPhoneForm) {
        try {
            // 调用微信小程序服务，获取用户的新手机号信息
            WxMaPhoneNumberInfo phoneNoInfo = wxMaService.getUserService().getPhoneNoInfo(updateWxPhoneForm.getCode());
            String phoneNumber = phoneNoInfo.getPhoneNumber();

            // 更新客户信息
            Long customerId = updateWxPhoneForm.getCustomerId();
            CustomerInfo customerInfo = customerInfoMapper.selectById(customerId);
            customerInfo.setPhone(phoneNumber);
            customerInfoMapper.updateById(customerInfo);

            return true;
        } catch (WxErrorException e) {
            throw new BusinessException(ResultCodeEnum.DATA_ERROR);
        }
    }

    /**
     * 获取客户OpenId
     */
    @Override
    public String getCustomerOpenId(Long customerId) {
        LambdaQueryWrapper<CustomerInfo> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(CustomerInfo::getId, customerId);
        // 从数据库中获取OpenId
        CustomerInfo customerInfo = customerInfoMapper.selectOne(wrapper);
        return customerInfo.getWxOpenId();
    }
}
