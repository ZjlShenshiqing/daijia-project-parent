package com.zjl.daijia.customer.controller;

import com.zjl.daijia.common.result.Result;
import com.zjl.daijia.customer.service.CustomerInfoService;
import com.zjl.daijia.model.form.customer.UpdateWxPhoneForm;
import com.zjl.daijia.model.vo.customer.CustomerLoginVO;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 顾客信息控制层
 * <p>
 * Created by Zhangjilin on 2025/6/30
 */
@Slf4j
@RestController
@RequestMapping("/customer/info")
@SuppressWarnings({"unchecked", "rawtypes"})
public class CustomerInfoController {

    @Autowired
    private CustomerInfoService customerInfoService;

    @Operation(summary = "获取客户登录信息")
    @GetMapping("/getCustomerLoginInfo/{customerId}")
    public Result<CustomerLoginVO> getCustomerLoginInfo(@PathVariable Long customerId) {
        CustomerLoginVO customerInfo = customerInfoService.getCustomerInfo(customerId);
        return Result.ok(customerInfo);
    }

    @Operation(summary = "小程序授权登录")
    @GetMapping("/login/{code}")
    public Result<Long> login(@PathVariable String code) {
        return Result.ok();
    }

    @Operation(summary = "更新客户微信手机号码")
    @PostMapping("/updateWxPhoneNumber")
    public Result<Boolean> updateWxPhoneNumber(@RequestBody UpdateWxPhoneForm updateWxPhoneForm) {
        return Result.ok(customerInfoService.updateWxPhoneNumber(updateWxPhoneForm));
    }

    @Operation(summary = "获取客户OpenId")
    @GetMapping("/getCustomerOpenId/{customerId}")
    public Result<String> getCustomerOpenId(@PathVariable Long customerId) {
        return Result.ok(customerInfoService.getCustomerOpenId(customerId));
    }
}
