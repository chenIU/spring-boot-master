package com.ruida.springbootdemo.stream.api;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @description: max&&min
 * @author: chenjy
 * @create: 2020-12-17 17:11
 */
public class Test6 {
    public static void main(String[] args) {
        List<Integer> hearList = Lists.newArrayList();
        hearList.add(15);
        hearList.add(32);
        hearList.add(5);
        hearList.add(232);
        hearList.add(56);
        hearList.add(29);
        hearList.add(94);
        Integer maxItem = hearList.stream().max(Integer::compareTo).get();
        Integer minItem = hearList.stream().min(Integer::compareTo).get();
        System.out.println("max:"+maxItem+"，min:"+minItem);
    }
}
