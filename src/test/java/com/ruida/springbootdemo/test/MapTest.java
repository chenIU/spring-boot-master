package com.ruida.springbootdemo.test;

import java.util.*;

/**
 * @description: map测试类
 * <p>
 *     集合在遍历时，如果对集合元素进行增删操作，会抛出ConcurrentModificationException
 * </p>
 * @author: chenjy
 * @create: 2020-04-28 10:08
 */
public class MapTest {

//    private static final Map<String,Object> MAP = new HashMap();
    private static Map<String,Object> MAP = new HashMap();

    {
        MAP.put("1","jay");
        MAP.put("2","chou");
    }

    public static void main(String[] args) {
        /*Map<String,Object> MAP = new HashMap();
        MAP.put("name","chenjy");
        MAP.put("age",21);
        MAP.put("height",1.72);
        Iterator<Map.Entry<String, Object>> it = MAP.entrySet().iterator();
        while(it.hasNext()){
            MAP.remove("name");
            Map.Entry entry = it.next();
            String key = (String) entry.getKey();
            Object value = entry.getValue();
            System.out.println("key=="+key+";value=="+value);
        }*/

        Map<String,Object> map = new HashMap();
        map.put("name","chenjy");
        map.put("age",26);
        map.put("school","LIT");
        map.put(null,"nil");//HashMap的key和value都可以为null
        map.put("hobby",null);
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

        //确保一个集合不被修改
        //final修饰一个成员变量，如果是基本数据类型，表示这个变量的值不能被修改。如果是引用类型，则表示这个引用的地址不能改变，但是这个引用指向对象的内容还是可以改变。
        //unmodifiableMap、unmodifiableList、unmodifiableSet
        MAP = Collections.unmodifiableMap(MAP);
        MAP.put("1","boy");
        System.out.println(MAP.get("1"));

    }
}
