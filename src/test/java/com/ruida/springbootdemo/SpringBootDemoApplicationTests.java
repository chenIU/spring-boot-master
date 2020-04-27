package com.ruida.springbootdemo;

import com.ruida.springbootdemo.bean.TestBean;
import com.ruida.springbootdemo.config.ApplicationContextConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//@SpringBootTest
class SpringBootDemoApplicationTests {

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

}
