package com.wangyuxuan.configure;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

/**
 * @author wangyuxuan
 * @date 2020/9/25 11:03 下午
 * @description
 */
@Controller
public class DepartCodeConfigure {

    // 负载均衡
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
