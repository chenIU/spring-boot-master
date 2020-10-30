package com.ruida.springbootdemo.test;

import com.ruida.springbootdemo.SpringBootDemoApplication;
import com.ruida.springbootdemo.entity.People;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-10-30 11:19
 */
@SpringBootTest(classes = SpringBootDemoApplication.class)
public class ConditionOnTest {

    @Autowired(required = false)
    private People people;

    @Test
    public void test(){
        System.out.println(people);
    }
}
