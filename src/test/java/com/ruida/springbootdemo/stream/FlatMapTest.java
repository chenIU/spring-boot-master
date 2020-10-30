package com.ruida.springbootdemo.stream;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-09-28 16:06
 */
public class FlatMapTest {

    public static void main(String[] args) {
        List<Integer> oneList = Lists.newArrayList(),
                twoList = Lists.newArrayList();

        oneList.add(34);
        oneList.add(23);
        oneList.add(87);

        twoList.add(29);
        twoList.add(48);
        twoList.add(92);

        Map<String, List<Integer>> testMap = Maps.newHashMap();
        testMap.put("1", oneList);
        testMap.put("2", twoList);
        //返回的是一个流的集合，但是我需要的是List<Integer>这样一个集合
        List<Stream<Integer>> testList = testMap.values().stream().map(number -> number.stream()).collect(Collectors.toList());
        testList.forEach(System.out::println);

        List<Integer> flatMapTest = testMap.values().stream().flatMap(number -> number.stream()).collect(Collectors.toList());
        flatMapTest.forEach(System.out::println);
    }
}
