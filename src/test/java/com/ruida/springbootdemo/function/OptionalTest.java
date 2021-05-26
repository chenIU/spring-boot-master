package com.ruida.springbootdemo.function;

import com.ruida.springbootdemo.entity.User;
import com.ruida.springbootdemo.exception.BaseException;

import java.util.Optional;

public class OptionalTest {

    public static void main(String[] args) {

        String str = "hello";

        Optional optional = Optional.ofNullable(str);
        optional.ifPresent(System.out::println);

        Optional name1 = Optional.of("jack");
        System.out.println(name1);

        Optional name2 = Optional.empty();
        System.out.println(name2);

        String name = null;
        Optional name3 = Optional.ofNullable(name);
        System.out.println(name3);

        System.out.println(name3.orElseGet(() -> "hello"));
        //System.out.println(Optional.ofNullable(name).orElseThrow(() -> new BizException("500","illegal argument")));
        try {
            name3.orElseThrow(() -> new BaseException(500,"error"));
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        System.out.println(Optional.ofNullable(str).orElse("default value"));

        User user = new User();

        /**
         * 创建Optional容器
         */
        //empty返回空的Optional
        //Optional.empty();

        //of只有在确定放入容器的对象不为null的时候调用，否则会产生NPE问题
        //Optional.of(user);

        //ofNullable在上下文中不确定要放入容器的对象是否为null，使用最多构造Optional容器的方法
        //Optional.ofNullable(user);

        /**
         * 取值
         */
        //orElse不管user是否为空都会执行createUser
        //User u = Optional.ofNullable(user).orElse(createUser());

        //orElseGet只有在user对象为空的时候才会执行createUser
        User u = Optional.ofNullable(user).orElseGet(() -> createUser());

        System.out.println(u);
    }

    private static User createUser(){
        System.out.println("执行createUser方法");
        User user = new User();
        user.setUsername("zhangsan");
        return user;
    }
}
