package com.ruida.springbootdemo.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 遍历Map的七种方式：
 * 1.迭代器EntrySet
 * 2.迭代器KeySet
 * 3.ForEach EntrySet
 * 4.ForEach KeySet
 * 5.lambda
 * 6.Stream
 * 7.parallelStream
 * 一般建议使用迭代EntrySet的方式，可以避免并发修改异常，更加直观
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
