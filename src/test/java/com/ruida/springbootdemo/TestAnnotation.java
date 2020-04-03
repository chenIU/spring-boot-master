package com.ruida.springbootdemo;

import com.ruida.springbootdemo.annotation.Alpha;
import lombok.extern.slf4j.Slf4j;
import java.lang.reflect.Field;

/**
 * @description: 测试注解
 * @author: chenjy
 * @create: 2020-04-03 09:55
 */
@Slf4j
public class TestAnnotation {
    public static void main(String[] args) {
        try {
            Class clazz = Class.forName("com.ruida.springbootdemo.entity.Student");
            Field[] fields = clazz.getDeclaredFields();
            for(Field field:fields){
                boolean flag = field.isAnnotationPresent(Alpha.class);
                if (flag){
                    log.info(field+"字段配置了Alpha注解");
                    Alpha alpha = field.getAnnotation(Alpha.class);
                    log.info("name="+alpha.name()+",value="+alpha.value());
                }else {
                    log.info(field+"字段没有配置Alpha注解");
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
