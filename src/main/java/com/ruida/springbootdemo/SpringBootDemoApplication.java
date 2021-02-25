package com.ruida.springbootdemo;

import com.ruida.springbootdemo.annotation.EnableFruitConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.spring.web.SpringfoxWebMvcConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
//MapperScan指定多个需要扫描的包
//@MapperScan({"com.ruida.springbootdemo.mapper","com.ruida.springbootdemo.dao"})
@MapperScan("com.ruida.springbootdemo.mapper")
@ConditionalOnClass(SpringfoxWebMvcConfiguration.class)
@EnableTransactionManagement
@EnableCaching
//@EnableScheduling
@EnableFruitConfiguration
@EnableAspectJAutoProxy(exposeProxy = true)
@Slf4j
public class SpringBootDemoApplication{

	public static void main(String[] args) {
		//http://localhost:8080/actuator 监控
		SpringApplication.run(SpringBootDemoApplication.class, args);
		log.warn("application start successful...");
	}

}
