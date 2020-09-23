package com.ruida.springbootdemo.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import java.lang.reflect.Modifier;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-09-23 16:56
 * 参考链接：https://www.jianshu.com/p/90881bfc3241
 */
@Aspect
@Component
@Slf4j
public class LogAspect {

    /**
     * 定义一个切入点，用来确定哪些类需要代理
     * 以下表达式表示com.ruida.springbootdemo.controller.log包下所有类的所有方法都将被代理
     */
    //通过表达式
    //@Pointcut("execution(* com.ruida.springbootdemo.controller.log.*.*(..))")
    //通过注解
    @Pointcut("@annotation(com.ruida.springbootdemo.annotation.AuthCheck)")
    public void declareJointPointExpression(){

    }

    /**
     * 前置方法，在目标方法执行前执行
     * JoinPoint封装了处理方法信息的对象，若用不到则可以忽略不写
     * @param jp
     */
    @Before("declareJointPointExpression()")
    public void before(JoinPoint jp){
        //方法信息
        MethodSignature methodSignature = (MethodSignature) jp.getSignature();
        log.warn("目标方法名：{}",methodSignature.getName());
        log.warn("目标方法所属类的类名：{}",methodSignature.getDeclaringTypeName());
        log.warn("目标方法所属类的简单名：{}",methodSignature.getDeclaringType().getSimpleName());
        log.warn("目标方法声明类型：{}", Modifier.toString(methodSignature.getModifiers()));

        //参数
        Object[] args = jp.getArgs();
        for(int i=0;i<args.length;i++){
            log.warn("第{}个参数是：{}",i+1,args[i]);
        }

        //代理信息
        log.warn("被代理的对象：{}",jp.getTarget());
        log.warn("代理对象自己：{}",jp.getThis());
    }

    /**
     * 环绕方法，自定义目标方法的执行时机
     * ProceedingJoinPoint是JoinPoint的子接口，添加了：
     * Object proceed() throws Throwable 执行目标方法
     * Object proceed(Object[] var1) throws Throwable 传入的新的参数去执行目标方法
     * 此方法需要返回值,返回值视为目标方法的返回值
     * @param pjp
     * @return
     */
    @Around("declareJointPointExpression()")
    public Object around(ProceedingJoinPoint pjp){
        Object result = null;

        try {
            log.warn("目标方法执行前");

            //执行目标方法
            //result = pjp.proceed();
            //用新的参数执行目标方法
            result = pjp.proceed(new Object[]{1,"jack"});
            log.warn("目标方法返回结果");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        log.warn("目标方法执行后");

        return result;
    }
}
