package com.white.service.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * All rights Reserved, Designed by xxxx
 *
 * @author: White
 * @date: 2018/8/21
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = "com.white.service.admin.mapper")
public class ServiceAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceAdminApplication.class, args);
    }
}
