package com.ruida.springbootdemo.application;

import com.ruida.springbootdemo.SpringBootDemoApplication;
import com.ruida.springbootdemo.entity.Org;
import com.ruida.springbootdemo.entity.Unit;
import com.ruida.springbootdemo.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-10-29 10:55
 */
@SpringBootTest(classes = SpringBootDemoApplication.class)
public class ApplicationTest {

    @Resource
    private Book book;

    @Autowired
    private Org org;

    @Autowired
    private Unit unit;

    @Test
    public void test1(){
        System.out.println(book);
    }

    @Test
    public void ConfigurationTest(){
        System.out.println(org == unit.getOrg());
    }
}
