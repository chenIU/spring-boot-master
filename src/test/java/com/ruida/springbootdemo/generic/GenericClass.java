package com.ruida.springbootdemo.generic;

/**
 * @description: 泛型类
 * 1.把泛型定义在类上
 * 2.类型变量定义在类上，方法中也可以使用
 * @author: chenjy
 * @create: 2020-09-30 16:20
 */
public class GenericClass<T> {

    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
