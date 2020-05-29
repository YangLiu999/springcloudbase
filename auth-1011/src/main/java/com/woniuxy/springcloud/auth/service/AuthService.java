package com.woniuxy.springcloud.auth.service;

import org.springframework.stereotype.Service;

/**
 * @author YL
 * @date 2020/05/26
 **/

public interface AuthService {
    public boolean hasPermission(String token,String persmission);
}
