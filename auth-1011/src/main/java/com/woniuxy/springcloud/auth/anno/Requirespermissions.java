package com.woniuxy.springcloud.auth.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author YL
 * @date 2020/05/26
 **/
@Retention(RetentionPolicy.RUNTIME) //注解保留策略
@Target(ElementType.METHOD)
public @interface Requirespermissions {
    String value();
}
