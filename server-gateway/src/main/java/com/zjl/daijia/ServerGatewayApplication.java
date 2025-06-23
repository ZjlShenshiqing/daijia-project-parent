package com.zjl.daijia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 网关启动
 * <p>
 * Created by Zhangjilin on 2025/5/30
 */
@EnableFeignClients
@EnableDiscoveryClient // 把当前服务注册到注册中心（如 Nacos、Eureka、Consul）中，并启用服务发现能力
@SpringBootApplication
public class ServerGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServerGatewayApplication.class, args);
    }

}
