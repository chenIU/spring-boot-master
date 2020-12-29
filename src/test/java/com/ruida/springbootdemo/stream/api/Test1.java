package com.ruida.springbootdemo.stream.api;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: filter方法
 * @author: chenjy
 * @create: 2020-12-17 16:59
 */
public class Test1 {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(3);
        numbers.add(4);
        numbers.add(8);
        numbers.add(16);
        numbers.add(19);
        numbers.add(27);
        numbers.add(23);
        numbers.add(99);
        numbers.add(15);
        numbers.add(32);
        numbers.add(5);
        numbers.add(232);
        numbers.add(56);
        long count = numbers.stream().filter(i -> i>20).count();
        System.out.println(count);
    }
}
