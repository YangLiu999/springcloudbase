package com.woniuxy.springcloud.auth.intercepter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.woniuxy.springcloud.auth.anno.Requirespermissions;
import com.woniuxy.springcloud.auth.service.AuthService;
import com.woniuxy.springcloud.common.entity.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.invoke.MethodHandle;
import java.lang.reflect.Method;

/**
 * @author YL
 * @date 2020/05/26
 **/
public class AuthHandlerIntercepter implements HandlerInterceptor {

    //Intercepter注入Bean,对象为null,还必须注册当前拦截器的bean
    @Autowired
    AuthService authService;

    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler) throws Exception {
        System.out.println("权限拦截");
        String token = request.getHeader("token");
        //判断当前的handle是不是一个方法处理器,权限的注解是添加在controller方法上
        if (handler instanceof HandlerMethod){
            Method method = ((HandlerMethod)handler).getMethod();
            //判断方法上是否存在Requirespermissions注解
            if (method.isAnnotationPresent(Requirespermissions.class)){
                Requirespermissions annotation = method.getAnnotation
                        (Requirespermissions.class);
                //取出注解的值
                String permission = annotation.value();
                //判断是否有权限
                if (!authService.hasPermission(token,permission)){
                    //拦截
                    response.getWriter().write(new ObjectMapper().writeValueAsString(
                            new ResponseResult<String>(403,"noPermission",null)
                    ));
                    return false;
                }
            }
        }
        //放行
        return true;
    }
}
