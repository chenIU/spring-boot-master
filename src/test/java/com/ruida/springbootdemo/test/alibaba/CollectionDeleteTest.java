package com.ruida.springbootdemo.test.alibaba;

import java.util.*;

/**
 * @description:
 * 如果list在for循环中调用remove方法会抛出并发修改异常，但是如果只修改了第一个元素就返回是个例外情况，因为这个时候不会调用next方法判断modCount和expectedModCount是否相等。
 * 用迭代器遍历则不会抛出此异常
 * @author: chenjy
 * @create: 2020-12-07 11:39
 */
public class CollectionDeleteTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list,"1","2");

        //for循环遍历删除
        for(String item:list){
            if(Objects.equals("2",item)){
                list.remove(item);
            }
        }
        System.out.println(list.size());

        //迭代器删除
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            String item = iterator.next();
            if(Objects.equals("2",item)){
                iterator.remove();
            }
        }
        System.out.println(list.size());
    }


}
