package com.ruida.springbootdemo.singleton.common;

/**
 * @desc 饿汉式(可能会浪费资源)
 * @author chenjy
 * @since 2021/1/3 9:30
 */
public class Hungry {

    private Hungry(){

    }

    private final static Hungry instance = new Hungry();

    public static Hungry getInstance(){
        return instance;
    }
}
