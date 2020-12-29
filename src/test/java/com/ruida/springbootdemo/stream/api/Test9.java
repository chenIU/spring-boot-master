package com.ruida.springbootdemo.stream.api;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * @description: 收集结果
 * @author: chenjy
 * @create: 2020-12-17 17:21
 */
public class Test9 {

    public static void main(String[] args) {
        List<Integer> hereList = Arrays.asList(1,2,3,100,3,50);

        List<Integer> thereList = hereList.stream().collect(Collectors.toList());//收集到List
        System.out.println(thereList);

        Set<Integer> thereSet = hereList.stream().collect(Collectors.toSet());//收集到Set
        System.out.println(thereSet);

        TreeSet<Integer> treeSet = hereList.stream().collect(Collectors.toCollection(TreeSet::new));//收集到TreeSet
        System.out.println(treeSet);
    }
}
