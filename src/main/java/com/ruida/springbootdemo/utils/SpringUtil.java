package com.ruida.springbootdemo.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-04-28 11:20
 */
@Component
@Slf4j
public class SpringUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.info("applicationContext正在初始化...");
        if (SpringUtil.applicationContext == null) {
            this.applicationContext = applicationContext;
        }
    }

    //通过class获取bean
    public static <T> T getBean(Class<T> clazz){
        return applicationContext.getBean(clazz);
    }

    //通过name获取bean
    public static Object getBean(String name){
        return applicationContext.getBean(name);
    }

    //通过name和clazz获取bean
    public static <T> T getBean(String name,Class<T> clazz){
        return applicationContext.getBean(name,clazz);
    }

    public static ApplicationContext getApplicationContext(){
        return applicationContext;
    }
    private SpringUtil(){

    }


}
