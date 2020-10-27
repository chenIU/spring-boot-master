package com.ruida.springbootdemo.config;

import com.ruida.springbootdemo.interceptor.GlobalInterceptor;
import com.ruida.springbootdemo.interceptor.JwtInterceptor;
import com.ruida.springbootdemo.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @description: web配置
 * @author: chenjy
 * @create: 2020-04-01 09:55
 */
@Component
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private JwtInterceptor jwtInterceptor;
    @Autowired
    private GlobalInterceptor globalInterceptor;
    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("doc.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor).addPathPatterns("/auth/**");
        registry.addInterceptor(globalInterceptor).addPathPatterns("/market/**");
        //registry.addInterceptor(loginInterceptor).addPathPatterns("/login/**");
    }
}
