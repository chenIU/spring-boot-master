package com.ruida.springbootdemo.stream.api;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description: 拼接
 * @author: chenjy
 * @create: 2020-12-17 17:27
 */
public class Test10 {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("chenjy","liuxiaoyu","suxiang");

        String joinString = stringList.stream().collect(Collectors.joining());
        System.out.println(joinString);

        String joinSplitString = stringList.stream().collect(Collectors.joining(","));
        System.out.println(joinSplitString);

        //当流中的元素不是字符串时，需要先转成字符串再拼接
        List<Integer> integerList = Arrays.asList(100,200,300);
        String joinConvertString = integerList.stream().map(String::valueOf).collect(Collectors.joining(","));
        System.out.println(joinConvertString);
    }
}
