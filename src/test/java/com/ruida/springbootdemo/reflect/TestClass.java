package com.ruida.springbootdemo.reflect;

import com.ruida.springbootdemo.model.Cat;
import com.ruida.springbootdemo.service.order.OrderConsumer;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

/**
 * @description: 测试获取class
 * @author: chenjy
 * @create: 2021-01-04 11:41
 */
public class TestClass {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> c1 = Class.forName("com.ruida.springbootdemo.model.Cat");
        System.out.println(c1);

        Class<Cat> c2 = Cat.class;
        System.out.println(c2);

        Cat cat = new Cat("Tom",3);
        Class<? extends Cat> c3 = cat.getClass();
        System.out.println(c3);
    }

    @Test
    public void test(){
        Class<?> clazz = OrderConsumer.class;
        //class com.ruida.springbootdemo.service.order.OrderConsumer
        System.out.println(clazz);

        //com.ruida.springbootdemo.service.order.OrderConsumer
        System.out.println(clazz.getName());

        //OrderConsumer
        System.out.println(clazz.getSimpleName());

        //orderConsumer
        System.out.println(StringUtils.uncapitalize(clazz.getSimpleName()));
    }
}
