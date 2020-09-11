package com.ruida.springbootdemo.test;

import com.ruida.springbootdemo.utils.Calculator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class JunitTest {

    @Before
    public void init(){
        System.out.println("init...");
    }

    @Test
    public void add(){
        //System.out.println("this is add method...");
        int result = new Calculator().add(1,2);
        Assert.assertEquals(3,result);
    }

    @After
    public void destroy(){
        System.out.println("destroy...");
    }
}
