package com.ruida.springbootdemo.test;

import java.util.ArrayList;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-11-25 13:03
 */
public class CollectionFailTest {
    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<>();
        list.add("chen");
        list.add("wang");
        list.add("chen");
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).equals("chen")){
                list.remove(i);
            }
        }
        System.out.println(list.toString());
    }
}
