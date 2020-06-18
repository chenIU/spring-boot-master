package com.ruida.springbootdemo;

import com.ruida.springbootdemo.service.BlogService2;
import com.ruida.springbootdemo.utils.PropertyUtil;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-06-12 10:26
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SpringBootDemoApplication.class})
@TestPropertySource(locations = "classpath:application-dev.yml")
@ActiveProfiles("dev")
public class IocTest {

    @Autowired
    BlogService2 service;

    @Test
    public void delete(){
        //service.delete(1);
        PropertyUtil.getProperty("username");
    }

}
