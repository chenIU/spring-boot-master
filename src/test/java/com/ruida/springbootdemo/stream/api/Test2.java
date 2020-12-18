package com.ruida.springbootdemo.stream.api;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @description: map
 * @author: chenjy
 * @create: 2020-12-17 17:01
 */
public class Test2 {

    public static void main(String[] args) {
        List<Integer> integerList = Lists.newArrayList();
        integerList.add(15);
        integerList.add(32);
        integerList.add(5);
        integerList.add(232);
        integerList.add(56);
        //将Integer类型转换成String类型
        List<String> afterString = integerList.stream().map(i->String.valueOf(i)).collect(Collectors.toList());
        afterString.stream().forEach(System.out::println);
    }
}
