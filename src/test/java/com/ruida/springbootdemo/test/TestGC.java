package com.ruida.springbootdemo.test;

import com.ruida.springbootdemo.model.Cat;

/**
 * @description: 测试垃圾回收
 * 对象在被引用时，是不会被GC的
 * @author: chenjy
 * @create: 2021-01-04 16:30
 */
public class TestGC {
    public static void main(String[] args) {
        new Cat("tom", 2);
        System.gc();
        //总结：由打印的日志可知新生代和老年代内存空间之和等于初始堆大小,元空间在逻辑上存在,真实并不存在
    }
}
