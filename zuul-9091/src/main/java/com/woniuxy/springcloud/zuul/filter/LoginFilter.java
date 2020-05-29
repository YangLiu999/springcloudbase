package com.woniuxy.springcloud.zuul.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.woniuxy.springcloud.common.entity.ResponseResult;
import com.woniuxy.springcloud.common.util.JwtUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class LoginFilter extends ZuulFilter {
    //拦截类型
    @Override
    public String filterType() {
        return "pre";
    }

    //拦截器的执行顺序：从小到大执行
    @Override
    public int filterOrder() {
        return 0;
    }

    //判断是否拦截：拦截条件配置
    @Override
    public boolean shouldFilter() {
        //请求路径带有/auth不拦截
//        RequestContext context = RequestContext.getCurrentContext();
//        HttpServletRequest request = context.getRequest();
//        String requestURI = request.getRequestURI();
//        if (requestURI.contains("/auth")){
//            return false;
//        }
//        return true;
        return false;
    }

    //拦截执行的方法，shouldFilter返回真才执行
    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        //参数带有token登录成功
        HttpServletRequest request = currentContext.getRequest();
        String token = request.getHeader("token");
        System.out.println(token);
        if (!StringUtils.isEmpty(token) && JwtUtil.verify(token)){
            System.out.println("放行");
            //放行
            return null;
        }
        System.out.println("zuul拦截");
        //拦截
        currentContext.setSendZuulResponse(false);
        //响应状态码
        try {
            currentContext.setResponseBody(new ObjectMapper().writeValueAsString(
                    new ResponseResult(401,"fail",null)));
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
