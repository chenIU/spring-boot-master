package com.ruida.springbootdemo;

import com.ruida.springbootdemo.annotation.MyAnnotation;
import com.ruida.springbootdemo.config.ApplicationContextConfig;
import com.ruida.springbootdemo.entity.bean.TestBean;
import com.ruida.springbootdemo.entity.fruit.Apple;
import com.ruida.springbootdemo.entity.fruit.Banana;
import com.ruida.springbootdemo.service.Vehicle;
import com.ruida.springbootdemo.service.impl.TestNotNullService;
import com.ruida.springbootdemo.service.impl.UserServiceImpl;
import com.ruida.springbootdemo.utils.LockUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.reflections.Reflections;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import javax.annotation.Resource;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= SpringBootDemoApplication.class)
@Slf4j
public class SpringBootDemoApplicationTests {

	@Resource
	UserServiceImpl userService;
	@Resource
	ApplicationContext applicationContext;
	@Resource
	TestNotNullService testNotNullService;
	@Resource
	Apple apple;
	@Resource
	Banana banana;
	@Resource
	private RedisTemplate<String,Object> redisTemplate;

	@Test
	public void contextLoads() {
		System.out.println(apple);
		System.out.println(banana);
	}

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


	/**
	 * Usages:
	 *
	 * Reflections reflections = new Reflections("my.project");
	 *
	 * Set<Class<? extends SomeType>> subTypes = reflections.getSubTypesOf(SomeType.class);
	 *
	 * Set<Class<?>> annotated = reflections.getTypesAnnotatedWith(SomeAnnotation.class);
	 */
	@Test
	public void testReflections(){
		//System.out.println("---"+applicationContext);
		Reflections reflections = new Reflections();
		Set<Class<? extends Vehicle>> subTypes = reflections.getSubTypesOf(Vehicle.class);
		for(Class<?> clazz : subTypes){
			System.out.println("========="+clazz.getName());
			System.out.println("========="+clazz.getSimpleName());
			Vehicle vehicle = (Vehicle) applicationContext.getBean(StringUtils.uncapitalize(clazz.getSimpleName()));
			vehicle.start();
		}

		System.out.println("=========================getTypesAnnotatedWith=========================");
		Set<Class<?>> annotated = reflections.getTypesAnnotatedWith(MyAnnotation.class);
		for(Class<?> clazz : annotated){
			System.out.println("========="+clazz.getSimpleName());
		}
	}

	@Test
	public void testNotNull(){

		//正常输出
		testNotNullService.show(0,"zhangsan");

		//报错
		testNotNullService.show(0,null);
	}

	@Test
	public void testRedisLock(){
		//redisTemplate.opsForValue().setIfAbsent("LOCK_ORDER_100",Thread.currentThread().getId(),30, TimeUnit.SECONDS);
		System.out.println(redisTemplate.opsForValue().setIfAbsent("lock", UUID.randomUUID(), 60L, TimeUnit.SECONDS));
	}

	@Test
	public void testRedisLock2(){
		String lockKey = "SyncData";
		String requiredId = UUID.randomUUID().toString();

		System.out.println("是否成功获取锁：" + LockUtil.tryLock(lockKey, requiredId , 60, 5, 1000));

		//模拟业务执行时间
		try {
			TimeUnit.SECONDS.sleep(30);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("是否成功释放锁：" + LockUtil.releaseLock(lockKey, requiredId));
	}
}
