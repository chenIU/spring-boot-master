package com.ruida.springbootdemo.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @description: web请求日志切面
 * @author: chenjy
 * @create: 2020-03-30 17:03
 */
@Aspect
@Component
@Slf4j
public class WebLogAspect {

    @Pointcut("execution(* com.ruida.springbootdemo.controller.*.*(..))")
    public void webLog(){

    }

    @Before("webLog()")
    public void deal(){
        log.info("进入http请求层日志切面");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        log.info("请求的路径为{}"+request.getRequestURL());
    }

}
