package com.ruida.springbootdemo.stream.api;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Objects;

/**
 * @description: reduce
 * @author: chenjy
 * @create: 2020-12-17 17:16
 */
public class Test8 {
    public static void main(String[] args) {
        List<Integer> hearList = Lists.newArrayList();
        hearList.add(15);
        hearList.add(32);
        hearList.add(5);
        hearList.add(232);
        hearList.add(56);
        hearList.add(29);
        hearList.add(104);
        //求和
        Integer sum = hearList.stream().reduce((x,y)->x+y).get();
        System.out.println("sum:"+sum);
        //简化一下，求和
        sum = hearList.stream().reduce(Integer::sum).get();
        System.out.println("sum:"+sum);
        //含有初始标识的，求和
        sum = hearList.stream().reduce(0,(x,y)->x+y);
        System.out.println("sum:"+sum);
        //对元素的长度进行求和( (total,y)->total+y.toString().length()，类似于一个累加器，会被重复调用)
        sum = hearList.stream().reduce(0,(total,y)->total+y.toString().length(),(total1,total2)->total1+total2);
        System.out.println("sum:"+sum);
        //简化一下，对元素长度进行求和
        sum = hearList.stream().map(Objects::toString).mapToInt(String::length).sum();
        System.out.println("sum:"+sum);
    }
}
