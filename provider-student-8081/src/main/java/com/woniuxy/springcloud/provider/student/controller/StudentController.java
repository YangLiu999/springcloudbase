package com.woniuxy.springcloud.provider.student.controller;

import com.woniuxy.springcloud.auth.anno.Requirespermissions;
import com.woniuxy.springcloud.common.entity.ResponseResult;
import com.woniuxy.springcloud.common.entity.Student;
import com.woniuxy.springcloud.provider.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
 //@CrossOrigin 允许跨域，和网关不能共存
public class StudentController {

    @Autowired
    StudentService studentService;

    @Value("${server.port}")
    private String port;
    //对外提供服务,对象必须使用@RequestBody
    @PostMapping("/")
    public ResponseResult addStudent(@RequestBody Student student){
        studentService.insertStudent(student);
        return new ResponseResult(200,"success"+port,null);
    }

    @GetMapping("/{sid}")
    public ResponseResult getStudentBysid(@PathVariable("sid") Integer sid){
        Student student = studentService.getStudentBysid(sid);
        return new ResponseResult(200,"success"+port,student);
    }

    //@Requirespermissions("select:student")
    @GetMapping("/")
    public ResponseResult<List<Student>> getAllStudents(){
        List<Student> students = studentService.getAllStudent();
        return new ResponseResult<List<Student>>(200,"success"+port,students);
    }

    //测试timeout:默认是1秒
    @RequestMapping("/timeout")
    public ResponseResult timeout(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new ResponseResult(200,"ok",null);
    }

    @RequestMapping("/ok")
    public ResponseResult ok(){
        return new ResponseResult(200,"ok",null);
    }
}
