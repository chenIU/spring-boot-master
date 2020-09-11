package com.ruida.springbootdemo.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-09-11 13:26
 */
@Service
public class TestNotNullService {

    public void show(int id,String name){
        Assert.notNull(id,"id can't null");
        Assert.notNull(name,"name can't be null");
        System.out.println("id="+id+",name="+name);
    }
}
