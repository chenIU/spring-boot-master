package com.ruida.springbootdemo.test.job;

import java.util.Arrays;
import java.util.List;

/**
 * @description: 由Array转换的集合不能使用增加、删除方法。原因是Arrays.asList返回的ArrayList是java.util.Arrays的内部类ArrayList，不是java.util.ArrayList。
 * @author: chenjy
 * @create: 2020-11-25 14:01
 */
public class Test2 {

    public static void main(String[] args) {
        String[] array = {"chen","wang","zhang"};
        List<String> list = Arrays.asList(array);
        System.out.println(list.size());
//        list.add("liu");
        list.remove("chen");
    }
}
