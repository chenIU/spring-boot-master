package com.ruida.springbootdemo;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.spring.web.SpringfoxWebMvcConfiguration;

@SpringBootApplication()
//MapperScan指定多个需要扫描的包
//@MapperScan({"com.ruida.springbootdemo.mapper","com.ruida.springbootdemo.dao"})
@MapperScan("com.ruida.springbootdemo.mapper")
@ConditionalOnClass(SpringfoxWebMvcConfiguration.class)
@EnableTransactionManagement
@EnableCaching
//@EnableScheduling
@Slf4j
public class SpringBootDemoApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		//http://localhost:8080/actuator 监控
		SpringApplication.run(SpringBootDemoApplication.class, args);
		log.warn("application start successful...");
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("doc.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}

}
