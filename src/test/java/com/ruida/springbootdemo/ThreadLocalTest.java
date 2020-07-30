package com.ruida.springbootdemo;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-07-30 14:15
 * <p>
 *     总结：
 *     1、ThreadLocal变量是每个线程独自占有的，各线程之间互不影响
 *     2、每个ThreadLocal变量只能存一个值，key是当前ThreadLocal线程实例
 *     3、不同的ThreadLocal对象存在当前线程的ThreadLocalMap类型的threadLocals变成中
 * </p>
 */
public class ThreadLocalTest {

    ThreadLocal<Long> longLocal = new ThreadLocal<>();
    ThreadLocal<String> stringLocal = new ThreadLocal<>();


    public void set() {
        longLocal.set(Thread.currentThread().getId());
        stringLocal.set(Thread.currentThread().getName());
    }

    public long getLong() {
        return longLocal.get();
    }

    public String getString() {
        return stringLocal.get();
    }

    public static void main(String[] args) throws InterruptedException {
        final ThreadLocalTest test = new ThreadLocalTest();


        test.set();
        System.out.println(test.getLong());
        System.out.println(test.getString());

        Thread thread1 = new Thread() {
            public void run() {
                test.set();
                System.out.println(test.getLong());
                System.out.println(test.getString());
            }
        };
        thread1.start();
        thread1.join();

        System.out.println(test.getLong());
        System.out.println(test.getString());
    }


    /*public static void main(String[] args) {
        ThreadLocal<Map<String,Object>> threadLocal = new ThreadLocal<>();
        Map<String,Object> map = new HashMap();
        map.put("username","chenjy");
        threadLocal.set(map);
        System.out.println(threadLocal.get().get("username"));
        System.out.println();

        ThreadLocal<String> tl = new ThreadLocal<>();
        tl.set("overmind");
        System.out.println(tl.get());

        ThreadLocal<String> tl2 = new ThreadLocal<>();
        tl2.set("china");
        System.out.println(tl2.get());
        System.out.println(tl.get());

        ThreadLocalTest test = new ThreadLocalTest();
        test.print();

        System.out.println(test);
    }

    public void print(){
        System.out.println(this);
    }*/
}
