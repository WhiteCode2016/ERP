package com.white.web.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * All rights Reserved, Designed by xxxx
 *
 * @author: White
 * @date: 2018/8/21
 */
@SpringBootApplication(scanBasePackages = "com.white")
@EnableDiscoveryClient
@EnableFeignClients
public class WebAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebAdminApplication.class, args);
    }
}
