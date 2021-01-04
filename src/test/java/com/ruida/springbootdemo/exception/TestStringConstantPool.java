package com.ruida.springbootdemo.exception;

import com.google.common.collect.Lists;
import java.util.ArrayList;

/**
 * @description: 测试字符串常量池
 * -Xms20m -Xms20m -XX:PermSize=8m -XX:MaxPermSize=8m
 * -Xms20m -Xms20m -XX:MetaspaceSize=8m -XX:MaxMetaspaceSize=20m
 * @author: chenjy
 * @create: 2021-01-04 15:31
 */
public class TestStringConstantPool {
    public static void main(String[] args) {
        for(String str:args){
            System.out.println(str);
        }
        ArrayList<Object> list = Lists.newArrayList();
        while (true){
            list.add(String.valueOf(System.currentTimeMillis()).intern());
        }
        //抛出：Exception in thread "main" java.lang.OutOfMemoryError: Java heap space,说明字符串常量池在堆中
    }
}
