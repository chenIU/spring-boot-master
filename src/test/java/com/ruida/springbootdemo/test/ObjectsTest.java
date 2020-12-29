package com.ruida.springbootdemo.test;

import com.ruida.springbootdemo.entity.User;

import java.util.Objects;

/**
 * @description:Objects.isNull()和object == null实质没有区别，出现的原因是jdk1.8出现了lambda表示式，filter(Object::isNull)要比filter(x -> x == null)直观
 * @author: chenjy
 * @create: 2020-12-21 11:53
 */
public class ObjectsTest {

    public static void main(String[] args) {
        User user = new User();
        //isNull
        System.out.println(Objects.isNull(user));//false

        //nonNull
        System.out.println(Objects.nonNull(user));//true

        //equals
        String username = "chenjy";
        System.out.println(Objects.equals(username,"chenjy"));//true
    }
}
