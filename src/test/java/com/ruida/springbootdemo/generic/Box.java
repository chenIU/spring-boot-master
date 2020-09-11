package com.ruida.springbootdemo.generic;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-09-10 16:31
 */
public class Box<T extends Number> {
    private T t;



    public void set(T t){
        this.t = t;
    }

    public T get(){
        return t;
    }
}
