package com.ruida.springbootdemo.entity.bean;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @description: 测试bean
 * @author: chenjy
 * @create: 2020-03-27 11:31
 */
@Component
@Lazy(false)
public class TestBean {

    private TestBean(){
        //System.err.println("TestBean is initializing......");
    }

    public void say(){
        System.err.println("I'm saying......");
    }
}
