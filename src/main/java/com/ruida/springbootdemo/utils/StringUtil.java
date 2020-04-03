package com.ruida.springbootdemo.utils;

/**
 * @description: string工具类
 * @author: chenjy
 * @create: 2020-04-01 14:49
 */
public class StringUtil {

    public static final String REDIS_KEY = "error_key_%s_%s";

    public static void main(String[] args) {
        System.out.println(String.format(REDIS_KEY, "iOS","bill"));
    }
}
