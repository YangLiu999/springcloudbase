package com.woniuxy.springcloud.consumer.student.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.woniuxy.springcloud.common.entity.ResponseResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumerHystrix")
public class HystrixController {

    @HystrixCommand(fallbackMethod = "testfallback",commandProperties = {
        @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//开启熔断器
        @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
        @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗口值
        @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "20"),//错误率
    })
    @RequestMapping("/{id}")
    public ResponseResult test(@PathVariable("id") Integer id){
        if (id>1){
            return new ResponseResult(200,"ok"+id,null);
        }else {
            throw new RuntimeException();
        }
    }

    public ResponseResult testfallback(@PathVariable("id") Integer id){
        return new ResponseResult(200,"testfallback"+id,null);
    }
}
