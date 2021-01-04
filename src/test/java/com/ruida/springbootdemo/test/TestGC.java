package com.ruida.springbootdemo.test;

/**
 * @description: 测试垃圾回收
 * @author: chenjy
 * @create: 2021-01-04 16:30
 */
public class TestGC {
    public static void main(String[] args) {
        System.gc();
        //总结：由打印的日志可知新生代和老年代内存空间之和等于初始堆大小,元空间在逻辑上存在,真实并不存在
    }
}
