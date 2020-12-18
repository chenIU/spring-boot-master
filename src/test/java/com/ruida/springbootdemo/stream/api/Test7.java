package com.ruida.springbootdemo.stream.api;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @description:
 * findFirst
 * findAny
 * anyMatch
 * @author: chenjy
 * @create: 2020-12-17 17:12
 */
public class Test7 {
    public static void main(String[] args) {
        List<Integer> hearList = Lists.newArrayList();
        hearList.add(15);
        hearList.add(32);
        hearList.add(5);
        hearList.add(232);
        hearList.add(56);
        hearList.add(29);
        hearList.add(104);
        Integer first = hearList.stream().filter(i->i>100).findFirst().get();
        System.out.println(first);

        Integer anyItem = hearList.stream().findAny().get();
        System.out.println(anyItem);

        boolean anyMatch = hearList.stream().anyMatch(i -> i>100);
        System.out.println(anyMatch);

        boolean noneMatch = hearList.stream().noneMatch(i->i>1000);
        System.out.println(noneMatch);
    }
}
