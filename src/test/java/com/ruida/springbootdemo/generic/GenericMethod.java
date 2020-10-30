package com.ruida.springbootdemo.generic;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-09-30 16:25
 */
public class GenericMethod {

    public <T> void show(T t){
        System.out.println(t);
    }
}
