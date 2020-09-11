package com.ruida.springbootdemo.test;

import com.ruida.springbootdemo.utils.PropertyUtil;

/**
 * @description: 测试工具类
 * @author: chenjy
 * @create: 2020-06-12 11:38
 */
public class TestUtils {

    public static void main(String[] args) {
        String username = PropertyUtil.getProperty("username");
        System.out.println(username);
    }

}
