package com.ruida.springbootdemo.stream.api;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @description: sorted
 * @author: chenjy
 * @create: 2020-12-17 17:10
 */
public class Test5 {
    public static void main(String[] args) {
        List<Integer> myTestList = Lists.newArrayList();
        myTestList.add(39);
        myTestList.add(78);
        myTestList.add(10);
        myTestList.add(22);
        myTestList.add(56);
        List<Integer> sortList = myTestList.stream().sorted(Integer::compareTo).collect(Collectors.toList());
        System.out.println("sortList："+sortList);
    }
}
