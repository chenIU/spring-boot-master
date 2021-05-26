package com.ruida.springbootdemo.application;

import com.google.common.collect.Lists;
import com.ruida.springbootdemo.SpringBootDemoApplication;
import com.ruida.springbootdemo.entity.Org;
import com.ruida.springbootdemo.entity.Unit;
import com.ruida.springbootdemo.entity.User;
import com.ruida.springbootdemo.model.Book;
import com.ruida.springbootdemo.service.order.OrderProducer;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-10-29 10:55
 */
@SpringBootTest(classes = SpringBootDemoApplication.class)
public class ApplicationTest {

    @Resource
    private RedisTemplate<String,Object> redisTemplate;
    @Resource
    private Book book;
    @Autowired
    private Org org;
    @Autowired
    private Unit unit;
    @Resource
    private OrderProducer orderProducer;

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


        //删除string类型
        redisTemplate.delete("name");

        //删除hash类型
        redisTemplate.delete("test");

        //批量删除
        List<String> keys = new ArrayList<>(Arrays.asList("L1","S1"));
        redisTemplate.delete(keys);

        //删除都是调用RedisTemplate的delete方法，不区分数据类型
    }

    @Test
    public void test(){
        System.out.println(orderProducer.send(500));
    }

    @SneakyThrows
    @Test
    public void testClassPathResource(){
        ClassPathResource cpr = new ClassPathResource("static" + File.separator + "gayhub.jpg");
        InputStream in = cpr.getInputStream();

        byte[] buf = new byte[8 * 1024];
        int len;
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("D://gayhub.jpg"));
        while ((len = in.read(buf)) != -1){
            bos.write(buf, 0, len);
        }
        //输出流的flush()方法一定要特别注意，否则可能出现少量数据未输出的情况
        bos.flush();
    }
}
