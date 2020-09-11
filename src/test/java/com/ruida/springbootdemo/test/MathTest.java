package com.ruida.springbootdemo.test;

import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-09-09 16:38
 */
public class MathTest {

    public static void main(String[] args) {
        List<Integer> list = aaa(40,100,3);
        list.forEach(x-> System.out.println(x));

    }

    public static List<Integer> aaa(int min,int max,int offset){
        List<Integer> list = new LinkedList<>();
        for(int i=min;i<=max;i+=offset){
            list.add(i);
        }
        return list;
    }
}
