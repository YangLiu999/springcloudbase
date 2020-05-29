package com.woniuxy.springcloud.provider.student;

import com.woniuxy.springcloud.provider.student.mapper.StudentMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author YL
 * @date 2020/05/21
 **/
@SpringBootTest
public class ProviderStudent8081ApplicationTests {

    @Autowired
    StudentMapper studentMapper;

    @Test
    public void testinsertStudent(){

        //studentMapper.insertStudent(new Student(1,"zs",15));
    }
}
