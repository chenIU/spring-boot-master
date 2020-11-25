package com.ruida.springbootdemo.test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @description: map测试类
 * <p>
 *     集合在遍历时，如果对集合元素进行增删操作，会抛出ConcurrentModificationException
 * </p>
 * @author: chenjy
 * @create: 2020-04-28 10:08
 */
public class MapTest {
    public static void main(String[] args) {
        /*Map<String,Object> map = new HashMap();
        map.put("name","chenjy");
        map.put("age",21);
        map.put("height",1.72);
        Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
        while(it.hasNext()){
            map.remove("name");
            Map.Entry entry = it.next();
            String key = (String) entry.getKey();
            Object value = entry.getValue();
            System.out.println("key=="+key+";value=="+value);
        }*/

        Map<String,Object> map = new HashMap();
        map.put("name","chenjy");
        map.put("age",26);
        map.put("school","LIT");
        System.out.println(map);

        map.forEach((k,v)->{
            System.out.println("key="+k);
            System.out.println("value="+v);
        });

        //有序Map
        //TreeMap根据key升序排序(基于Comparator实现排序)
        TreeMap treeMap = new TreeMap();
        treeMap.put(1,"chenjy");
        treeMap.put(3,"liuxy");
        treeMap.put(2,"suxiang");
        System.out.println(treeMap);

        //LinkedHashMap根据插入顺序排序(基于链表实现排序)
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(3,"suxiang");
        linkedHashMap.put(1,"chenjy");
        linkedHashMap.put(2,"liuxy");
        System.out.println(linkedHashMap);

        //HashMap和HashTable都不是有序的
    }
}
