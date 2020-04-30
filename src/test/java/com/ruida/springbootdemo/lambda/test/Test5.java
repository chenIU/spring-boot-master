package com.ruida.springbootdemo.lambda.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @description: lambda操作集合
 * @author: chenjy
 * @create: 2020-04-24 14:34
 */
public class Test5 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList();
        Collections.addAll(list,1,20,3,40,5);

        //lambda表达式，方法的引用
        list.forEach(System.out::println);

        //排序
        list.sort(Integer::compareTo);
        list.forEach(System.out::println);

        //遍历集合
        list.forEach(e -> {
            if(e%2==0){
                System.out.println("偶数："+e);
            }
        });

        //删除集合中的元素
        list.removeIf(e -> e%2 ==0);
        list.forEach(System.out::println);



    }

}
