package com.woniuxy.springcloud.auth.controller;

import com.woniuxy.springcloud.common.entity.ResponseResult;
import com.woniuxy.springcloud.common.util.JwtUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YL
 * @date 2020/05/26
 **/
@RestController
public class UserController {

    @RequestMapping("/login")
    public ResponseResult<String> login(String uname,String password){
        if (uname.equals("a")&&password.equals("aaa")){
            //登录成功生成token
            String token = JwtUtil.create(uname);
            return new ResponseResult<String>
                    (200,"loginsuccess",token);
        }

        return new ResponseResult<String>(401,"loginfail",null)
;    }
}
