package com.ruida.springbootdemo;

import com.ruida.springbootdemo.bean.TestBean;
import com.ruida.springbootdemo.config.ApplicationContextConfig;
import com.ruida.springbootdemo.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=SpringBootDemoApplication.class)
public class SpringBootDemoApplicationTests {

	@Resource
	UserServiceImpl userService;

/*	@Test
	void contextLoads() {
	}*/

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationContextConfig.class);
		TestBean tb = (TestBean) context.getBean("testBean");
		System.out.println(tb);
		tb.say();

		TestBean tb2 = (TestBean) context.getBean("testBean");
		System.out.println(tb2);
	}

	@Test
	public void getUserById(){
		userService.selectUserById(1);
	}

}
