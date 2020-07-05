package com.ruida.springbootdemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: list测试类
 * @author: chenjy
 * @create: 2020-04-28 10:55
 */
public class ListTest {
    public static void main(String[] args) {

        /*List<Integer> list = new ArrayList<>();
        Collections.addAll(list,1,2,3,4,5);
        if (list != null) {
            for (Integer i : list) {
                System.out.println(i);
            }
        }*/

        String [] arr = {"1","2","3"};
        List<String> list = Arrays.asList(arr);
        System.out.println(list.toString());
        /**
         * 抛出UnsupportedOperationException，Arrays.asList返回的list不支持增加删除操作
         * 原因，不是真正的java.util.ArrayList
         */
        //list.add("4");

        /**
         * 互相之间相互影响
         * 原因：asList方法底层使用了原始数组
         */
        list.set(0,"100");
        System.out.println(Arrays.toString(arr));
        arr[1] = "200";
        System.out.println(list);

        /**
         * List#subList内部也有一个字段保留了原始list
         * 注意，subList很可能产生OOM问题
         */

        /**
         * foreach增加/删除时不能增加/修改元素
         * 原因：foreach其实是java提供的一种语法糖，底层使用的还是list的迭代器
         * 解决方法：1、Iterator#remove元素
         *          2、JDK1.8 List#removeIf
         */
        String[] arrays = {"1", "2", "3"};
        List<String> list2 = new ArrayList<>(Arrays.asList(arrays));
       /* for (String str : list2) {
            if (str.equals("1")) {
                list2.remove(str);
            }
        }*/
        list2.removeIf(str -> str.equals("3"));
        System.out.println(list2);

        /**
         * 总结:
         * 第一，我们不要先入为主，想当然就认为 Arrays.asList 和 List.subList 就是一个普通，独立的 ArrayList。
         * 如果没办法，使用了 Arrays.asList 和 List.subList ，返回给其他方法的时候，一定要记得再套娃一层真正的 java.util.ArrayList。
         * 第二 JDK 的提供的不可变集合实际非常笨重，并且低效，还不安全，所以推荐使用 Guava 不可变集合代替。
         * 最后，切记，不要随便在 foreach增加/删除元素。
         */
    }
}
