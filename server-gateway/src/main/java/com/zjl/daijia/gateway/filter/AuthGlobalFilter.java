package com.zjl.daijia.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 全局Filter，统一处理会员登录与外部不允许访问的服务
 * GlobalFilter 允许你对所有经过 Gateway 的请求和响应进行统一的预处理和后处理，例如：
 * 鉴权（权限校验）
 * 请求日志打印
 * 请求头修改
 * 响应增强
 * 限流、拦截等
 * <p>
 * Created by Zhangjilin on 2025/5/30
 */
@Slf4j
@Component
public class AuthGlobalFilter implements GlobalFilter, Ordered {

    /**
     * ServerWebExchange
     * 封装了 HTTP 请求和响应的上下文对象
     * （包含请求头、路径、响应等）
     *
     * GatewayFilterChain
     * 表示网关中的过滤器链，用于继续后续的处理流程
     * @param exchange
     * @param chain
     * @return
     */
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
