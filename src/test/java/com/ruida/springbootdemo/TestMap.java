package com.ruida.springbootdemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-05-18 15:05
 */
public class TestMap {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list,1,2,3,50,20);
        list.forEach(item ->{
            System.out.println(item);
        });

        list.sort(Integer::compareTo);

        list.forEach(System.out::println);

    }
}
