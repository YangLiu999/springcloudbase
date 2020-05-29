package com.woniuxy.springcloud.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableEurekaClient
@EnableZuulProxy //启动网关
@SpringBootApplication
public class ZuulApplication9091 {
    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication9091.class,args);
    }
}
