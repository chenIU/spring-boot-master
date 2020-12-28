package com.ruida.springbootdemo.test;

import com.google.common.collect.Lists;

import java.util.ArrayList;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-12-28 16:57
 */
public class ArrayListTest {

    public static void main(String[] args) {
        ArrayList<String> list = Lists.newArrayList("a","a","b","b","c","c");

        for (int i = 0; i < list.size(); i++) {
            if("b".equals(list.get(i))){
                list.remove(i);
            }
        }
        System.out.println(list);

        //原因：System.arraycopy,在进行数据移除的时候,是对原数组进行拷贝
    }
}
