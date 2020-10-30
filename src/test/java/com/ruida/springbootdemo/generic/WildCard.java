package com.ruida.springbootdemo.generic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-09-30 16:29
 */
public class WildCard {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        Collections.addAll(list1,"Mike","Tome","Jack");
        test1(list1);

        Collections.addAll(list2,100,200,300);
        test1(list2);

        test2(list2);

    }

    public static void test1(List<?> list){
        list.forEach(System.out::println);
    }

    /*
     * 通配符上限
     */
    public static void test2(List<? extends Number> list){
        list.forEach(System.out::println);
    }
}
