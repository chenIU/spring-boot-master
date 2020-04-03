package com.ruida.springbootdemo.interceptor;

import com.ruida.springbootdemo.enums.ErrorEnum;
import com.ruida.springbootdemo.exception.BizException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description: 全局拦截器
 * @author: chenjy
 * @create: 2020-04-01 09:53
 */
@Component
public class GlobalInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return check(request,response);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    private boolean check(HttpServletRequest request,HttpServletResponse response){
        String requestHeader = request.getHeader("Authorization");
        if(null==requestHeader||"".equals(requestHeader)){
            throw new BizException(ErrorEnum.E_10001);
        }
        return true;
    }

}
