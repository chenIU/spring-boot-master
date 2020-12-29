package com.ruida.springbootdemo.test;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @description: 泛型中T的使用方法
 * @author: chenjy
 * @create: 2020-12-29 17:18
 */
public class GenericTypeTest {
    public static <T> T getFirstElement(List<T> list){
        if(list == null || list.isEmpty()){
            return null;
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        List<Integer> integerList = Lists.newArrayList(1,2,3);
        System.out.println(getFirstElement(integerList));

        List<String> stringList = Lists.newArrayList("jack","mike","lily");
        System.out.println(getFirstElement(stringList));
    }
}
