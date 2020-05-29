package com.woniuxy.springcloud.consumer.student.feignclient;

import com.woniuxy.springcloud.common.entity.ResponseResult;
import com.woniuxy.springcloud.common.entity.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

//指定feign调用服务名称
@FeignClient(value = "provider-student",fallback = StudentFeignClientFallBack.class)
@RequestMapping("/student")
public interface StudentFeignClient {

    @RequestMapping("/timeout")
    public ResponseResult timeout();

    @RequestMapping("/ok")
    public ResponseResult ok();

    @PostMapping("/")
    public ResponseResult addStudent(Student student);

    @GetMapping("/{sid}")
    public ResponseResult<Student> getStudentBySid(@PathVariable("sid") Integer sid);

    @GetMapping("/")
    public ResponseResult<List<Student>> getAllStudent();
}
