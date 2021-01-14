package com.ruida.springbootdemo.test;

import com.ruida.springbootdemo.model.Cat;

/**
 * @description: 测试传递类型(Java中只有值传递,没有引用类型传递)
 * @author: chenjy
 * @create: 2021-01-04 11:52
 */
public class TestTransferType {

    public static void main(String[] args) {
        //1.基本数据类型
        int i = 1;
        System.out.println("调用changeNum之前:" + i);
        changeNum(i);
        System.out.println("调用changeNum之后:" + i);

        Cat tom = new Cat("Tom", 3);
        System.out.println("调用changeCat之前，猫的年龄：" + tom.getAge() + " " + tom);
        changeCat(tom);
        System.out.println("调用changeCat之后，猫的年龄：" + tom.getAge() + " " + tom);
    }

    /**
     * 基本引用类型的参数是值传递
     * @param x
     */
    public static void changeNum(int x){
        x = 2;
    }

    /**
     * 引用类型参数只是原对象引用的一份拷贝，用拷贝对象来操作堆空间中的真实对象，但是对象本身的引用并没有改变
     * 所以说引用类型也是值传递
     * @param cat
     */
    public static void changeCat(Cat cat){
        cat.setAge(10);
    }
}
