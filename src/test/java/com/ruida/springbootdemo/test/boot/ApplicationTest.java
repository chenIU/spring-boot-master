package com.ruida.springbootdemo.test.boot;

import com.ruida.springbootdemo.SpringBootDemoApplication;
import com.ruida.springbootdemo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

/**
 * @author Chen.J.Y
 * @date 2021/5/26
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootDemoApplication.class)
public class ApplicationTest implements ApplicationContextAware {

    /**
     * : 的作用是给一个默认值，在yml文件中没有该配置时，也不会报错
     */
    @Value("${test.name:}")
    private String name;

    /**
     * 利用EL表达式解析yml文件中的list数据结构，set、map与此类似
     */
    @Value("#{'${test.list:}'.empty ? null : '${test.list:}'.split(',')}")
    private List<String> stringList;

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

    @Test
    public void test2(){
        System.out.println(name);
    }

    @Test
    public void test3(){
        stringList.forEach(System.out::println);
    }
}
