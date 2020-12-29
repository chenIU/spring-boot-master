package com.ruida.springbootdemo.lambda;

/**
 * @description:
 * Q：为什么Lambda表达式(匿名类)不能访问非final类型的局部变量
 * A：因为实例变量存放在堆中，而局部变量是在栈上分配，Lambda表示式（匿名类）会在另一个线程上执行。如果在一个线程中访问一个局部变量，此局部变量可能已经被销毁了。
 * 而final类型的局部变量在Lambda表示式（匿名类）中其实是一个局部变量的拷贝。
 * @author: chenjy
 * @create: 2020-12-17 11:25
 */
public class FinalVariableTest {

    static int a = 1;

    public static void main(String[] args) {

        int b = 2;
        //此时b已经被lambda表达式显示声明为final类型，不能改变变量的值了
//        b = 3;
        final int c = 3;
        Thread thread = new Thread(() -> {
            System.out.println(a);//可以访问成员变量
            //编译报错,final类型的变量不能被重新赋值
//            b = b + 1;
            System.out.println(b);//隐式的final类型局部变量
            System.out.println(c);//可能访问final类型的局部变量
        });
        thread.start();
    }
}
