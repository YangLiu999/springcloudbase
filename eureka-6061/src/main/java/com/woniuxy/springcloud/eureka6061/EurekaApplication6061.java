package com.woniuxy.springcloud.eureka6061;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaClient
@SpringBootApplication
@EnableEurekaServer //启用Eureka服务器
public class EurekaApplication6061 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication6061.class,args);
        }
}
