package com.ruida.springbootdemo.application;

import com.ruida.springbootdemo.SpringBootDemoApplication;
import com.ruida.springbootdemo.model.Book;
import org.junit.jupiter.api.Test;
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

    @Test
    public void test1(){
        System.out.println(book);
    }
}
