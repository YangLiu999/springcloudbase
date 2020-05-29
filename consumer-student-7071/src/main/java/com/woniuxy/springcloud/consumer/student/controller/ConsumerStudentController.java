package com.woniuxy.springcloud.consumer.student.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.woniuxy.springcloud.common.entity.ResponseResult;
import com.woniuxy.springcloud.common.entity.Student;
import com.woniuxy.springcloud.consumer.student.feignclient.StudentFeignClient;
import lombok.With;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;
//配置统一的降级方法
//@DefaultProperties(defaultFallback = "consumerFallBack")
@RestController
@RequestMapping("/consumerstudent")
public class ConsumerStudentController {

    //RestTemplate调用其他模块方法
//    @Autowired
//    RestTemplate restTemplate;

    //通过注册中心调用其他模块服务
//    @Autowired
//    DiscoveryClient discoveryClient;
//
//    //通过注册中心的名称获取服务信息
//    public String getUrl(){
//        //注册发现：restTemplate+discoveryClient，通过注册中心查找ＩＰ地址和端口
//        final List<ServiceInstance> instances = discoveryClient.getInstances("provider-student");
//        ServiceInstance instance = instances.get(0);
//        return "http://"+instance.getHost()+":"+instance.getPort()+"/student/";
//    }
//    public String getUrl(){
//        return "http://provider-student/student/";
//    }

    @Autowired
    StudentFeignClient studentFeignClient;

    @PostMapping("/")
    public ResponseResult addStudent(Student student){
//        return restTemplate.postForObject(
//                getUrl(),student,ResponseResult.class);
        //配置feign后的写法
        return studentFeignClient.addStudent(student);
    }

    @GetMapping("/{sid}")
    public ResponseResult<Student> getStudentBySid(@PathVariable("sid") Integer sid){
//        return restTemplate.getForObject(
//                getUrl()+sid,ResponseResult.class);
        return  studentFeignClient.getStudentBySid(sid);
    }

    @GetMapping("/")
    public ResponseResult<List<Student>> getAllStudent(){
//        return restTemplate.getForObject(
//                getUrl(),ResponseResult.class);
        return studentFeignClient.getAllStudent();
    }

    //测试timeout:默认是1秒
    //配置降级方法
    //@HystrixCommand(fallbackMethod = "timeoutfallback")
   // @HystrixCommand
    @RequestMapping("/timeout")
    public ResponseResult timeout(){
        return studentFeignClient.timeout();
    }

    /*public ResponseResult timeoutfallback(){
        return new ResponseResult(200,"timeoutfallback",null);
    }*/

    //@HystrixCommand
    @RequestMapping("/ok")
    public ResponseResult ok(){
        return studentFeignClient.ok();
    }

//    public ResponseResult consumerFallBack(){
//        return new ResponseResult(200,"consumerFallBack",null);
//    }
}
