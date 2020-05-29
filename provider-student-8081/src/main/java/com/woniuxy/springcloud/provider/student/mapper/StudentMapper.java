package com.woniuxy.springcloud.provider.student.mapper;

import com.woniuxy.springcloud.common.entity.Student;

import java.util.List;

/**
 * @author YL
 * @date 2020/05/21
 **/
public interface StudentMapper {
    void insertStudent(Student student);
    Student getStudentBysid(Integer sid);
    List<Student> getAllStudent();
}
