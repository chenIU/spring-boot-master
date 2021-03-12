package com.ruida.springbootdemo.reflect;

import com.ruida.springbootdemo.annotation.DesensitizeAnnotation;
import com.ruida.springbootdemo.core.mq.consumer.MQConsumer;
import com.ruida.springbootdemo.service.OrderService;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;
import org.reflections.scanners.FieldAnnotationsScanner;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Set;

/**
 * @desc 测试reflections
 * @author chenjy
 * @date 2021/3/12
 */
public class TestReflections {

    /**
     * 扫描子类
     */
    @Test
    public void test(){
        Reflections reflections = new Reflections(new ConfigurationBuilder().setUrls(ClasspathHelper.forPackage("com.ruida.springbootdemo")).setScanners(new SubTypesScanner()));
        Set<Class<? extends OrderService>> classes = reflections.getSubTypesOf(OrderService.class);
        for(Class<?> clazz : classes){
            System.out.println(clazz.getName());
        }
    }

    /**
     * 扫描类注解
     */
    @Test
    public void test2(){
        Reflections reflections = new Reflections(new ConfigurationBuilder().setUrls(ClasspathHelper.forPackage("com.ruida.springbootdemo")).setScanners(new TypeAnnotationsScanner()));
        Set<Class<?>> classes = reflections.getTypesAnnotatedWith(MQConsumer.class,true);
        for(Class<?> clazz : classes){
            System.out.println(clazz.getName());
        }
    }

    /**
     * 扫描字段注解
     */
    @Test
    public void test3(){
        Reflections reflections = new Reflections(new ConfigurationBuilder().setUrls(ClasspathHelper.forPackage("com.ruida.springbootdemo")).setScanners(new FieldAnnotationsScanner()));
        Set<Field> fields = reflections.getFieldsAnnotatedWith(DesensitizeAnnotation.class);
        fields.forEach(System.out::println);
    }

    /**
     * 扫描方法注解
     */
    @Test
    public void test4(){
        Reflections reflections = new Reflections(new ConfigurationBuilder().setUrls(ClasspathHelper.forPackage("com.ruida.springbootdemo")).setScanners(new MethodAnnotationsScanner()));
        Set<Method> methods = reflections.getMethodsAnnotatedWith(Autowired.class);
        methods.forEach(System.out::println);
    }
}
