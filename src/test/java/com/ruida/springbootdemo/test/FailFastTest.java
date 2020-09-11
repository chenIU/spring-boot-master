package com.ruida.springbootdemo.test;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @description: 快速失败测试类
 * @author: chenjy
 * @create: 2020-04-28 09:57
 */
public class FailFastTest {

    //private static List<String> list = new ArrayList<>();
    private static List<String> list = new CopyOnWriteArrayList<>();

    public static void main(String[] args) {

        Thread thread1 = new Thread(()->{
            for(int i=0;i<5;i++){
                list.add("线程一测试fail-fast"+i);
            }
            printAll();
        });

        Thread thread2 = new Thread(()->{
            for(int i=0;i<5;i++){
                list.add("线程二测试fail-fast"+i);
            }
            printAll();
        });
        thread1.start();
        thread2.start();
    }

    private static void printAll(){
        String value = null;
        Iterator it = list.iterator();
        while(it.hasNext()){
            value = (String) it.next();
            System.out.println(value);
        }
    }
}
