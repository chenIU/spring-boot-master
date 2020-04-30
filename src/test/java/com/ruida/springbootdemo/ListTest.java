package com.ruida.springbootdemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @description: list测试类
 * @author: chenjy
 * @create: 2020-04-28 10:55
 */
public class ListTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list,1,2,3,4,5);
        if (list != null) {
            for (Integer i : list) {
                System.out.println(i);
            }
        }
    }
}
