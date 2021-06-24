package com.ruida.springbootdemo.test;

import com.google.common.base.Joiner;
import com.google.common.collect.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-09-29 11:01
 */
public class GuavaTest {

    public static void main(String[] args) {

        ArrayList<String> list = Lists.newArrayList("jack","mike","john");
        list.forEach(System.out::println);

        /*
         * 创建普通map不需要new关键字
         */
        Map<String,Object> map = Maps.newHashMap();
        map.put("name","chenjy");
        map.put("age",26);

        /*
         * 不可变map
         */
        ImmutableMap<String, Integer> immutableMap = ImmutableMap.<String, Integer>builder()
                .put("Jack",1000)
                .put("Mike",2000)
                .put("John",3000)
                .build();

        //不可变map创建之后,不能再修改
        //immutableMap.put("Amy",4000);
        System.out.println(immutableMap.toString());

        /*
         * 有序的不可变map
         */
        ImmutableSortedMap<String, Integer> salary = new ImmutableSortedMap
                .Builder<String, Integer>(Ordering.natural())
                .put("John", 1000)
                .put("Jane", 1500)
                .put("Adam", 2000)
                .put("Tom", 2000)
                .build();
        System.out.println(salary.toString());

        /*
         * BiMap,双向映射的map,但是要保证key和value的唯一性
         */
        BiMap<String, Integer> words = HashBiMap.create();
        words.put("First", 1);
        words.put("Second", 2);
        words.put("Third", 3);
        System.out.println(words);
        System.out.println(words.inverse());

        /*
         * MultiMap,一个键关联多个值
         */
        Multimap<String, String> multimap = ArrayListMultimap.create();
        multimap.put("fruit", "apple");
        multimap.put("fruit", "banana");
        multimap.put("pet", "cat");
        multimap.put("pet", "dog");
        System.out.println(multimap.toString());

        /*
         * ClassToInstanceMap,把类作为键映射至对象
         */
        ClassToInstanceMap<Number> numbers = MutableClassToInstanceMap.create();
        numbers.putInstance(Integer.class, 1);
        numbers.putInstance(Double.class, 1.5);
    }

    /**
     * Joiner将内容以指定字符串分割
     */
    @Test
    public void testJoiner(){
        System.out.println(Joiner.on(";").join(1, 2, 3));
        List<Integer> list = Lists.newArrayList(1, 2, 3);
        System.out.println(Joiner.on("#").join(list));
    }
}
