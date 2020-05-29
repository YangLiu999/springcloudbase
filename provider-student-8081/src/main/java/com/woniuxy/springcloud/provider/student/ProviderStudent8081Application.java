package com.woniuxy.springcloud.provider.student;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author YL
 * @date 2020/05/21
 **/

@ComponentScan("com.woniuxy.springcloud") //配置包扫描，防止其他模块的包扫不到
@EnableDiscoveryClient
@EnableEurekaClient //启用eureka客户端
@SpringBootApplication
@MapperScan("com.woniuxy.springcloud.provider.student.mapper")
public class ProviderStudent8081Application {
    public static void main(String[] args) {
        SpringApplication.run(ProviderStudent8081Application.class,args);
    }
}
