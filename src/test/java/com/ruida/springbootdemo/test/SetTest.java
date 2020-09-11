package com.ruida.springbootdemo.test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @description: set测试类
 * <p>
 *     测试ConcurrentModificationException
 * </p>
 * @author: chenjy
 * @create: 2020-04-28 10:13
 */
public class SetTest {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("jack");
        set.add("mike");
        set.add("tom");
        set.add("john");
        Iterator<String> it = set.iterator();
        while(it.hasNext()){
            set.remove("jack");
            String value = it.next();
            System.out.println(value);
        }
    }
}
