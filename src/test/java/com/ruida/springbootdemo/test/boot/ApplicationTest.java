package com.ruida.springbootdemo.test.boot;

import com.ruida.springbootdemo.SpringBootDemoApplication;
import com.ruida.springbootdemo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

/**
 * @author Chen.J.Y
 * @date 2021/5/26
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootDemoApplication.class)
public class ApplicationTest implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Test
    public void test(){
        Map<String, UserService> beansOfType = applicationContext.getBeansOfType(UserService.class);
        log.info(String.valueOf(beansOfType.size()));
        for(String beanName : beansOfType.keySet()){
            log.info("bean name->{},bean-{}",beanName,beansOfType.get(beanName));
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
