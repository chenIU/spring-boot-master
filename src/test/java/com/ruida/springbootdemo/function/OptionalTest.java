package com.ruida.springbootdemo.function;

import com.ruida.springbootdemo.entity.User;

import java.util.Optional;

public class OptionalTest {

    public static void main(String[] args) {
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
        user.setName("zhangsan");
        return user;
    }
}
