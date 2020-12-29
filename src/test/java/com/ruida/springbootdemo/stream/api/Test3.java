package com.ruida.springbootdemo.stream.api;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @description: flatMap
 * @author: chenjy
 * @create: 2020-12-17 17:04
 */
public class Test3 {
    public static void main(String[] args) {
        List<Integer> oneList = Lists.newArrayList(),
                twoList = Lists.newArrayList();
        oneList.add(34);
        oneList.add(23);
        oneList.add(87);

        twoList.add(29);
        twoList.add(48);
        twoList.add(92);
        Map<String,List<Integer>> testMap = Maps.newHashMap();
        testMap.put("1",oneList);
        testMap.put("2",twoList);

        //map
        //返回的是一个流的集合，但是我需要的是List<Integer>这样一个集合
        List<Stream<Integer>> testList = testMap.values().stream().map(number->number.stream()).collect(Collectors.toList());
        testList.stream().forEach(System.out::println);

        //flatMap
        List<Integer> testList2 = testMap.values().stream().flatMap(number->number.stream()).collect(Collectors.toList());
        testList2.stream().forEach(System.out::println);
    }
}
