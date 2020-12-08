package com.ruida.springbootdemo.test.job;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 增强for循环fail-fast，不能在遍历的时候增加或删除集合中的元素
 * @author: chenjy
 * @create: 2020-11-25 14:09
 */
public class Test3 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("chen");
        list.add("wang");
        list.add("liu");
        for (String name:list){
            if("chen".equals(name)){
                list.remove(name);
            }
        }
    }
}
