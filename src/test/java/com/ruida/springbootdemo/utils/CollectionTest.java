package com.ruida.springbootdemo.utils;

import java.util.Arrays;
import java.util.List;

/**
 * @description: 集合测试类
 * @author: chenjy
 * @create: 2020-04-17 10:50
 */
public class CollectionTest {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("mike","john","amy");
        for(String s:list){
            System.out.println(s);
        }
    }

}
