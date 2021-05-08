package com.ruida.springbootdemo.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @description: ApplicationContextAware的作用是获取ApplicationContext对象
 * @author: chenjy
 * @create: 2020-04-28 11:20
 */
@Slf4j
@Component
public class SpringContextHolder implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    /**
     * 特点
     * 1、只有一个非静态方法能使用此注解
     * 2、被注解的方法不得有任何参数
     * 3、被注解的方法返回值必须为void
     * 4、被注解方法不得抛出已检查异常
     * 5、此方法只会被执行一次
     */
    @PostConstruct
    public void init(){
        log.info("init...");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.info("applicationContext正在初始化...");
        if (SpringContextHolder.applicationContext == null) {
            SpringContextHolder.applicationContext = applicationContext;
        }
    }

    /**
     * 通过class获取bean
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> clazz){
        return applicationContext.getBean(clazz);
    }

    /**
     * 通过name获取bean
     * @param name
     * @return
     */
    public static Object getBean(String name){
        return applicationContext.getBean(name);
    }

    /**
     * 通过name和class获取bean
     * @param name
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getBean(String name,Class<T> clazz){
        return applicationContext.getBean(name,clazz);
    }

    public static ApplicationContext getApplicationContext(){
        return applicationContext;
    }

    private SpringContextHolder(){

    }

}
