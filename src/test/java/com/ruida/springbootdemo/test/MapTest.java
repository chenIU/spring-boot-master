package com.ruida.springbootdemo.test;

import com.google.common.collect.Maps;
import com.ruida.springbootdemo.entity.App;
import org.junit.Test;

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

        iterateMap();

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

    public static void iterateMap(){
        Map<String,String> map = new HashMap();
        map.put("1","China");
        map.put("2","Japan");
        map.put("3","USA");

        //第一种方式：普通遍历，二次取值
        for(String key:map.keySet()){
            System.out.println("key==="+key+",value==="+map.get(key));
        }

        System.out.println("=========");

        //第二种方式：通过Iterator循环遍历Map.entrySet
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String,String> entry = iterator.next();
            System.out.println("key==="+entry.getKey()+",value==="+entry.getValue());
        }

        System.out.println("=========");

        //第三种方式：foreach，推荐，当容量较大时，效率比第二种高
        for(Map.Entry<String,String> entry:map.entrySet()){
            System.out.println("key==="+entry.getKey()+",value==="+entry.getValue());
        }

        System.out.println("=========");

        //第四种方式：利用Map.values遍历所有的value，但是不能遍历key
        for(String v:map.values()){
            System.out.println("value=="+v);
        }

        System.out.println("=========");

        //第五种方式：利用lambda表达式
        map.forEach((k,v) -> System.out.println("key==="+k+",value==="+v));
    }

    @Test
    public void test(){
        App app = new App("微信","张小龙","腾讯");
        App app1 = new App("微信","张小龙","腾讯");

        System.out.println("app的hashcode" + app.hashCode());
        System.out.println("app1的hashcode" + app1.hashCode());
        System.out.println(app == app1);//false

        Map<Object,Object> map = new HashMap();
        map.put(app,"aaa");
        map.put(app1,"bbb");

        map.forEach((k,v) -> {
            System.out.println(k);
        });

        //通过输出结果可知,map的大小为2
        //原因分析：HashMap通过key的hashCode和equals方法判断key是否重复

        //重写App的hashCode和equals方法(两个方法必须同时重写,只重写其中任意一个都不行)
        //结果符合预期
    }

    @Test
    public void test2(){
        Map<Integer,Object> map = new HashMap();
        map.put(100,"Amy");
        map.put(3,"Jack");
        map.put(1,"Mike");
        map.put(2,"Tom");
        System.out.println(map);
        System.out.println(orderByKey(map,true));
        System.out.println(orderByKey(map,false));
    }

    /**
     * map 排序
     * @param map 需要排序的map
     * @param asc 升序还是降序
     * @param <K> key
     * @param <V> value
     * @return
     */
    public <K extends Comparable<? super K>,V> Map<K,V> orderByKey(Map<K,V> map,boolean asc){
        if(map == null || map.isEmpty()){
            return null;
        }

        Map<K,V> result = Maps.newLinkedHashMap();

        if(asc){
            map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEachOrdered(e -> result.put(e.getKey(),e.getValue()));
        }else {
            map.entrySet().stream().sorted(Map.Entry.<K,V>comparingByKey().reversed()).forEachOrdered(e -> result.put(e.getKey(),e.getValue()));
        }
        return result;
    }

    @Test
    public void test3(){
        List<String> animals = Arrays.asList("dog", "cat", "cat", "dog", "fish", "dog");
        Map<String, Integer> map = new HashMap<>();
        for(String animal : animals){
            map.compute(animal, (k, v) -> v == null ? 1 : ++v);
        }
        System.out.println(map);
    }
}
