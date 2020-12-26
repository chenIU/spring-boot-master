package com.ruida.springbootdemo.test;

import com.google.common.collect.*;
import org.junit.Test;

import java.util.*;

/**
 * @author chenjy
 * @since 2020/12/26 13:16
 */
public class GuavaDemo {

    /**
     * 过滤器
     */
    @Test
    public void testGuava1(){
        List<String> list = Lists.newArrayList("java","php","ruby","javascript");
        Collection<String> res = Collections2.filter(list, e -> e.startsWith("j"));
        res.forEach(System.out::println);
    }

    /**
     * 转换
     */
    @Test
    public void testGuava2(){
        Set<String> set = Sets.newHashSet("1","2","3");
        Collection<Double> transform = Collections2.transform(set, e -> Double.valueOf(e));
        transform.forEach(System.out::println);
    }

    /**
     * 集合的交并差
     */
    @Test
    public void testGuava3(){
        Set<Integer> s1 = Sets.newHashSet(1,2,3);
        Set<Integer> s2 = Sets.newHashSet(3,4,5);

        //交集
        Sets.SetView<Integer> v1 = Sets.intersection(s1, s2);
//        v1.forEach(System.out::println);

        //差集
        Sets.SetView<Integer> v2 = Sets.difference(s1, s2);
//        v2.forEach(System.out::println);

        //并集
        Sets.SetView<Integer> v3 = Sets.union(s1, s2);
        v3.forEach(System.out::println);
    }

    /**
     * Multiset:无序可重复
     */
    @Test
    public void testGuava4(){
        String s = "good good study day day up";
        String[] ss = s.split(" ");
        HashMultiset<String> set = HashMultiset.create();

        for(String str : ss){
            set.add(str);
        }

        Set<String> elementSet = set.elementSet();
        for(String str : elementSet){
            System.out.println(str + "-" + set.count(str));
        }
    }

    /**
     * Multimap:key可以重复
     */
    @Test
    public void testGuava5(){
        Map<String,String> map = new HashMap();
        map.put("Java从入门到精通","jack");
        map.put("PHP从入门到精通","jack");
        map.put("SpringBoot入门教程","mike");
        map.put("Docker实战","john");

        Multimap<String,String> mmap = ArrayListMultimap.create();
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, String> entry = iterator.next();
            mmap.put(entry.getValue(),entry.getKey());
        }

        Set<String> keys = mmap.keySet();
        for(String key : keys){
            Collection<String> values = mmap.get(key);
            System.out.println(key + "->" + values);
        }
    }

    /**
     * BiMap:双向map，key和value都不重复
     */
    @Test
    public void testGuava6(){
        HashBiMap<String, String> biMap = HashBiMap.create();
        biMap.put("chenjy","177777777");
        biMap.put("liuxy","188888888");

        String name = biMap.inverse().get("177777777");
        System.out.println(name);
    }

    /**
     * 双键的map
     */
    @Test
    public void testGuava7(){
        HashBasedTable<String, String, Integer> table = HashBasedTable.create();
        table.put("jack","Java",80);
        table.put("mike","PHP",90);
        table.put("lily","Ruby",59);

        Set<Table.Cell<String, String, Integer>> cells = table.cellSet();
        for (Table.Cell cell : cells){
            System.out.println(cell.getRowKey() + "-" + cell.getColumnKey() + "-" + cell.getValue());
        }
    }
}
