package com.woniuxy.springcloud.consumer.student;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableHystrix //启用降级
@EnableFeignClients//启用feign
@EnableEurekaClient
 //@EnableDiscoveryClient //启用服务发现
@SpringBootApplication
public class ConsumerProvider7071Application {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerProvider7071Application.class,args);
    }
}
