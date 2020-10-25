package com.ruida.springbootdemo.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.ruida.springbootdemo.constant.SystemConstant;

import java.util.Calendar;
import java.util.Map;

public class JwtUtil {

    /**
     * 生成token
     * @param payload
     * @return
     */
    public static String getToken(Map<String,String> payload){

        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DATE,7);//token7天过期

        JWTCreator.Builder builder = JWT.create();

        payload.forEach((k,v) -> {
            builder.withClaim(k,v);
        });

        String token = builder.withExpiresAt(instance.getTime()).sign(Algorithm.HMAC256(SystemConstant.TOKEN_SALT));
        return token;
    }

    /**
     * 验证token
     * @param token
     * @return
     */
    public static DecodedJWT verify(String token){
        return JWT.require(Algorithm.HMAC256(SystemConstant.TOKEN_SALT)).build().verify(token);
    }
}
