package com.ruida.springbootdemo.stream.api;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @description: distinct
 * @author: chenjy
 * @create: 2020-12-17 17:09
 */
public class Test4 {
    public static void main(String[] args) {
        List<Integer> myTestList = Lists.newArrayList();
        myTestList.add(10);
        myTestList.add(39);
        myTestList.add(10);
        myTestList.add(78);
        myTestList.add(10);
        List<Integer> distinctList = myTestList.stream().distinct().collect(Collectors.toList());
        distinctList.stream().forEach(System.out::println);
    }
}
