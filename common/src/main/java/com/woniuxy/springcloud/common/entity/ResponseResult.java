package com.woniuxy.springcloud.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author YL
 * @date 2020/05/21
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseResult<T> {

    //响应状态码
    private Integer stateCode;
    //响应消息
    private String message;
    //响应数据
    private T data;
}
