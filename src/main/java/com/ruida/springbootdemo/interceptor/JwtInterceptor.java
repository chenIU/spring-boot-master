package com.ruida.springbootdemo.interceptor;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ruida.springbootdemo.entity.result.MapResult;
import com.ruida.springbootdemo.utils.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@Slf4j
public class JwtInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        log.info("token is :{}",token);

        MapResult<String,String> map = new MapResult<>();
        map.setSuccess(false);
        try {
            JwtUtil.verify(token);
            return true;
        }catch (TokenExpiredException e){
            map.setErrorMsg("token已过期!");
        }catch (AlgorithmMismatchException e){
            map.setErrorMsg("签名算法不匹配!");
        }catch (SignatureVerificationException e){
            map.setErrorMsg("签名错误!");
        }catch (Exception e){
            //e.printStackTrace();
            map.setErrorMsg("无效token");
        }

        String json = new ObjectMapper().writeValueAsString(map);//jackson将对象转为json字符串
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().println(json);
        return false;
    }
}
