package com.ruida.springbootdemo.test;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-09-11 14:26
 *
 *
 * 执行顺序：
 *          静态代码块->Main方法->构造代码块->普通代码->构造方法->普通方法（代码块）
 */
public class ClassDemoTest {

    static int num;

    public static void main(String[] args) {
        System.out.println("Main方法"+num++);//1
        ClassDemoTest demo = new ClassDemoTest();
        demo.show();
    }

    static{
        System.out.println("静态代码块"+num++);//0
    }

    {
        System.out.println("构造代码块"+num++);//2
    }

    public void show(){
        {
            System.out.println("普通代码块"+num++);//4
        }
    }

    public ClassDemoTest(){
        System.out.println("构造方法"+num++);//3
    }
}
