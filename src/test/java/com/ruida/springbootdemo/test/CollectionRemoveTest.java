package com.ruida.springbootdemo.test;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @description: 对Java集合进行遍历删除是务必使用迭代器
 * @author: chenjy
 * @create: 2020-12-21 15:01
 */
public class CollectionRemoveTest {

    public static void main(String[] args) {
        List<String> users = Lists.newArrayList("chenjy","liuxy","chensx");
        //foreach遍历删除抛出java.util.ConcurrentModificationException，会出现一个元素可以正常遍历删除的特殊情况，具体第几个和元素的个数有关
//        for(String username:users){
//            if(username.equals("chenjy")){
//                users.remove(username);
//            }
//        }

        //迭代器遍历删除正常
        Iterator<String> iterator = users.iterator();
        while(iterator.hasNext()){
            String username = iterator.next();
            if(username.equals("chenjy")){
                iterator.remove();
            }
        }

        //for循环遍历删除正常
//        for (int i = 0; i < users.size(); i++) {
//            if(users.get(i).equals("chenjy")){
//                users.remove(i);
//            }
//        }
        System.out.println(users);

        //这个方法存在一个严重的错误，当一个元素被删除时，列表的大小缩小并且下标发生变化。所以想要在一个循环中利用下标删除所有元素，它并不会正常生效。
        List<String> list = new ArrayList<>(Arrays.asList("a","b","c","d"));
        for (int i = 0; i < list.size(); i++) {
            list.remove(i);
        }
        System.out.println(list);
    }
}
