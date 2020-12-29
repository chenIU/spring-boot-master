package com.ruida.springbootdemo.test;

import com.ruida.springbootdemo.entity.User;
import java.util.Date;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-12-17 16:11
 */
public class ReferenceParamTest {

    public static void main(String[] args) {
        User user = new User();
        user.setUsername("陈俭银");
        System.out.println(user);
        checkParam(user);
        System.out.println(user);
    }

    private static void checkParam(User user){
        user.setCreateTime(new Date());
    }
}
