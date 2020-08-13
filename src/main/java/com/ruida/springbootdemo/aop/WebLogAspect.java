package com.ruida.springbootdemo.aop;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
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

    /**
     * 处理方法请求时间
     */
    ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Pointcut("execution(* com.ruida.springbootdemo.controller..*.*(..))")
    public void log(){
        log.warn("this is pointcut method...");
    }

    @Before("log()")
    public void before(JoinPoint point){
        startTime.set(System.currentTimeMillis());
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        Runtime rt = Runtime.getRuntime();
        long freeMemory = rt.freeMemory();
        log.info("before 当前Java虚拟机中空闲内存量："+freeMemory+"字节");
        // 请求url
        log.info("before url={}",request.getRequestURL());
        // 请求method
        log.info("before method={}",request.getMethod());
        log.info("before contentType={}",request.getContentType());
        // 请求参数
        log.info("before args={}",point.getArgs());
        // 请求类方法
        log.info("before class_method={}",point.getSignature().getDeclaringTypeName()+","+point.getSignature().getName());
    }

    @Around("log()")
    public Object around(ProceedingJoinPoint pjp){
        Object result = null;
        Class<?> returnType;
        Object[] args = pjp.getArgs();
        log.info("around args={}",args.toString());

        Signature signature = pjp.getSignature();
        if(!(signature instanceof MethodSignature)){
            throw new IllegalArgumentException("该注解只能用于方法");
        }

        StopWatch stopWatch = new StopWatch();

        MethodSignature methodSignature = (MethodSignature) signature;
        Object target =pjp.getTarget();
        String className = target.getClass().getName();
        log.info("around className={}",className);
        String methodName = signature.getName();
        log.info("around methodName={}",methodName);
        returnType = methodSignature.getReturnType();
        try {
            stopWatch.start();
            if("void".equals(returnType.getName())){

            }
            result = pjp.proceed();
            stopWatch.stop();
        }catch (Throwable ex){
            // do something
        }finally {

        }
        return result;
    }

    @After("log()")
    public void after(){
        log.info("after 耗时{}",System.currentTimeMillis() - startTime.get()+"毫秒");

        Runtime rt = Runtime.getRuntime();
        long freeMemory = rt.freeMemory();
        log.info("after 当前Java虚拟机中空闲内存量："+freeMemory+"字节");
    }

    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfterReturning(Object object){
        Runtime rt = Runtime.getRuntime();
        long freeMemory = rt.freeMemory();
        log.info("doAfterReturning 当前Java虚拟机中的空闲内存量：" + freeMemory + " 字节");
        log.info("doAfterReturning response={}", JSONObject.toJSONString(object));
        log.info("doAfterReturning 耗时: " + (System.currentTimeMillis() - startTime.get())+"毫秒");
        startTime.remove();
    }
}
