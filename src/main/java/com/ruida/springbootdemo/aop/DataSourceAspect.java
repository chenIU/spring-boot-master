package com.ruida.springbootdemo.aop;

import com.ruida.springbootdemo.annotation.DataSource;
import com.ruida.springbootdemo.config.DynamicDataSourceContextHolder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import java.lang.reflect.Method;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-10-29 09:16
 */
@Aspect
@Component
@Order(1)
public class DataSourceAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataSourceAspect.class);

    @Pointcut("@annotation(com.ruida.springbootdemo.annotation.DataSource)")
    public void dataSourcePointCut(){

    }

    @Around("dataSourcePointCut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        Method method = methodSignature.getMethod();
        DataSource dataSource = method.getAnnotation(DataSource.class);
        if(dataSource != null){
            LOGGER.info("开始进行数据源切换...");
            DynamicDataSourceContextHolder.setDataSourceType(dataSource.value().name());
        }

        try {
            return pjp.proceed();
        } finally {
            //在执行完方法之后，销毁指定的数据源
            DynamicDataSourceContextHolder.clearDataSourceType();
        }
    }
}
