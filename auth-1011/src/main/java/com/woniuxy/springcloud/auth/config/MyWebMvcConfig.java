package com.woniuxy.springcloud.auth.config;

import com.woniuxy.springcloud.auth.intercepter.AuthHandlerIntercepter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author YL
 * @date 2020/05/26
 **/
@Configuration
public class MyWebMvcConfig {

    //Intercepter注入Bean,对象为null,还必须注册当前拦截器的bean
    @Bean
    public AuthHandlerIntercepter authHandlerIntercepter(){

        return new AuthHandlerIntercepter();
    }

    //配置拦截路径
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(authHandlerIntercepter())
                        .addPathPatterns("/**");
            }
        };
    }
}
