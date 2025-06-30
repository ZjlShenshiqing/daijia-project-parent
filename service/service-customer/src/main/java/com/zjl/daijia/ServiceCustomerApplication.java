package com.zjl.daijia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 顾客微服务启动类
 * <p>
 * Created by Zhangjilin on 2025/6/30
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class ServiceCustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceCustomerApplication.class, args);
    }
}
