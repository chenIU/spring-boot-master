package com.ruida.springbootdemo.model;

/**
 * @description:
 * 子类构造方法都会默认调用父类的无参构造方法,目的是帮助子类完成初始化工作
 * @author: chenjy
 * @create: 2020-04-29 17:33
 */
public class Son extends Father{

    private Integer id;

    private String name;

    public Son() {
    }

    public Son(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public void eat(){
        System.out.println("son eating...");
    }
}
