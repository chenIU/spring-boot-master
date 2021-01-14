package com.ruida.springbootdemo.collection;

import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @desc 阻塞队列常用API
 * @author chenjy
 * @since 2021/1/3 9:16
 */
public class TestQueue {

    @Test
    public void test1(){
        BlockingQueue queue = new ArrayBlockingQueue(3);
        queue.add("a");
        queue.add("b");
        queue.add("c");
//        queue.add("d");

        queue.remove();
        queue.remove();
        queue.remove();
        queue.remove();

        //总结：add、remove这组api,当不能添加和移除的时候抛异常

        System.out.println(queue.size());
    }

    @Test
    public void test2(){
        BlockingQueue queue = new ArrayBlockingQueue(3);
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");
        queue.offer("d");

        queue.poll();
        queue.poll();
        queue.poll();
        queue.poll();

        //总结：offer和poll这组api,当无法增加或者移除的时候不抛出异常

        System.out.println(queue.size());
    }

    @Test
    public void test3() throws InterruptedException {
        BlockingQueue queue = new ArrayBlockingQueue(3);
        queue.put("a");
        queue.put("b");
        queue.put("c");
//        queue.put("d");

        queue.take();
        queue.take();
        queue.take();
//        queue.take();

        //总结：put和take这组api,当无法增加或者移除元素的时候一直等待
        System.out.println(queue.size());
    }

    //其他,offer poll 重载的方法可以实现超时等待效果

}
