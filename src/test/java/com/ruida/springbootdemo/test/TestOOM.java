package com.ruida.springbootdemo.test;

/**
 * @author chenjy
 * @since 2021/1/2 23:39
 */
public class TestOOM {

    public static void main(String[] args) {
        // 默认最大内存是主机内存的1/4，初始化内存是主机内存的1/64
        long max = Runtime.getRuntime().maxMemory();
        long total = Runtime.getRuntime().totalMemory();
        System.out.println("JVM最大内存" + max + "字节" + "," + (double)(max / 1024 / 1024) + "M");
        System.out.println("JVM初始化内存" + total + "字节" + "," + (double)(total / 1024 / 1024) + "M");

        // 模拟OOM
        a();
    }

    public static void a(){
        b();
    }

    public static void b(){
        a();
    }
}
