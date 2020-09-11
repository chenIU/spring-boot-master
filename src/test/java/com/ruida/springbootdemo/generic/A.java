package com.ruida.springbootdemo.generic;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-09-10 16:21
 */

public class A<T> {
    T t;
    int id;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
