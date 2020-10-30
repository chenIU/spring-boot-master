package com.ruida.springbootdemo.test.boot;

import com.ruida.springbootdemo.SpringBootDemoApplication;
import com.ruida.springbootdemo.component.MailModuleProperties;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-10-30 16:30
 */
@SpringBootTest(classes = SpringBootDemoApplication.class)
public class ConfigurationTest {

    @Resource
    private MailModuleProperties mailModuleProperties;

    @Test
    public void test(){
        System.out.println(mailModuleProperties);
    }
}
