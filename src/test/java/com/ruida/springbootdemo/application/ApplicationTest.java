package com.ruida.springbootdemo.application;

import com.google.common.collect.Lists;
import com.ruida.springbootdemo.SpringBootDemoApplication;
import com.ruida.springbootdemo.entity.Org;
import com.ruida.springbootdemo.entity.Unit;
import com.ruida.springbootdemo.entity.User;
import com.ruida.springbootdemo.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-10-29 10:55
 */
@SpringBootTest(classes = SpringBootDemoApplication.class)
public class ApplicationTest {

    @Resource
    private RedisTemplate redisTemplate;
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

    @Test
    public void test2(){
        List<User> userList = Lists.newArrayList(
                new User("Jack",10),
                new User("Mike",30),
                new User("Tony",20)
        );

        redisTemplate.opsForHash().put("test","user",userList);
        redisTemplate.opsForHash().put("test","name","jack");

        redisTemplate.opsForValue().set("name","Mike");
    }
}
