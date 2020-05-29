package com.woniuxy.springcloud.auth.service.impl;

import com.woniuxy.springcloud.auth.service.AuthService;
import com.woniuxy.springcloud.common.util.JwtUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YL
 * @date 2020/05/26
 **/
@Service
public class AuthServiceImpl implements AuthService {
    //判断是否存在相应权限
    @Override
    public boolean hasPermission(String token, String persmission) {
        String uname = JwtUtil.getUname(token);
        //从数据库中查询用户权限
        List<String> permissions = new ArrayList<>();
        permissions.add("select:student");
        permissions.add("insert:student");
        return permissions.contains(persmission);
    }
}
