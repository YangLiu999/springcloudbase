package com.woniuxy.springcloud.common.util;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;

/**
 * JWT工具类
 */
public class JwtUtil {
    //定义秘钥：类似盐
    private final static String SECRET = "woniuxy";
    //定义签发人
    private final static String ISSUER = "java";
    //指定token过期时间
    private final static int EXPIRES = 30*60*1000;

    //生成token，携带自定义信息(用户名）
    public static String create(String uname){
        //定义加密算法
        Algorithm algorithm = Algorithm.HMAC256(SECRET);
        Date now = new Date();
        //过期时间
        Date expires = new Date(now.getTime() + EXPIRES);
        //生成token
        String token = JWT.create()
                .withIssuer(ISSUER)
                .withIssuedAt(now)
                .withClaim("uname", uname)
                .withExpiresAt(expires)
                .sign(algorithm);
        return  token;
    }

    //验证token是否合法
    public static boolean verify(String token){
        try {
            //定义加密算法
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            JWTVerifier build = JWT.require(algorithm).withIssuer(ISSUER).build();
            build.verify(token);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    //获取用户名
    public static String getUname(String token){
        try {
            return JWT.decode(token).getClaim("uname").asString();
        }catch (Exception e){
            return null;
        }
    }

//    public static void main(String[] args) {
////        String token1 = create("zs");
////        System.out.println(token1);
////        System.out.println(verify(token1));
////        System.out.println(getUname(token1));
//        Integer a = new Integer(5);
//        System.out.println(a);
//    }
}
