package com.woniuxy.springcloud.provider.student.service;

import com.woniuxy.springcloud.common.entity.Student;

import java.util.List;


public interface StudentService {

    void insertStudent(Student student);
    Student getStudentBysid(Integer sid);
    List<Student> getAllStudent();
}
