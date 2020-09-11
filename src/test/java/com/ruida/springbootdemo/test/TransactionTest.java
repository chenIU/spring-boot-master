package com.ruida.springbootdemo.test;

import com.ruida.springbootdemo.entity.Blog;
import com.ruida.springbootdemo.service.BlogService1;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-06-12 09:13
 *
 */
@SpringBootTest
public class TransactionTest {
    @Autowired
    BlogService1 service1;

    @Test
    public void contextLoads() {
        Blog blog = new Blog(2,"cn","https://cn.com");
        service1.save(blog);
    }

}
