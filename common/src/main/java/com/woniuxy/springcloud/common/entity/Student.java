package com.woniuxy.springcloud.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author YL
 * @date 2020/05/21
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {

    private  Integer sid;
    private  String sname;
    private  Integer sage;
}
