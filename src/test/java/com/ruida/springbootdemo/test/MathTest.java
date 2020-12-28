package com.ruida.springbootdemo.test;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-09-09 16:38
 */
public class MathTest {

    public static void main(String[] args) {
        System.out.println(Math.pow(2,10));
        List<Integer> list = aaa(40,100,3);
        list.forEach(x-> System.out.println(x));
        System.out.println("===================");
        list.forEach(System.out::println);
    }

    public static List<Integer> aaa(int min,int max,int offset){
        List<Integer> list = new LinkedList<>();
        for(int i=min;i<=max;i+=offset){
            list.add(i);
        }
        return list;
    }

    @Test
    public void minTest(){
        System.out.println(Math.min(10,1));//1
        //Math.max()求两个数的较大值
    }
}
