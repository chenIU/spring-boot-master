package com.ruida.springbootdemo.utils;

import java.util.*;

/**
 * @description: 集合测试类
 * @author: chenjy
 * @create: 2020-04-17 10:50
 */
public class CollectionTest {

    public static void main(String[] args) {

        //集合有序性测试

        //HashMap是无须的
        Map<String,Object> map = new HashMap();
        map.put("name","chenjy");
        map.put("age",25);
        map.put("school","lit");
        System.out.println(map);

        //LinkedHashMap是有序的
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("name","chenjy");
        linkedHashMap.put("age",25);
        linkedHashMap.put("school","lit");
        System.out.println(linkedHashMap);

        //ArrayList是有序的
        List<String> numberList = new ArrayList<>();
        numberList.add("1");
        numberList.add("2");
        numberList.add("3");
        System.out.println(numberList);

        int[] arr1 = new int[]{1,2,3};
        int[] arr2 = arr1;
        arr1[1]=100;
        System.out.println(arr1[1]);
        System.out.println(arr2[1]);

        /*List<String> list = Arrays.asList("mike","john","amy");
        for(String s:list){
            System.out.println(s);
        }*/

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);

        List<Float> list2 = new ArrayList<>();
        list2.add(1.2f);
        CollectionTest test = new CollectionTest();
        test.show(1);
        test.test(list);
        test.test(list2);
    }

    public <T> void show(T t){
        System.out.println(t);
    }

    public void test(List<? extends Number> list){
        System.out.println(list.size());
    }

}
