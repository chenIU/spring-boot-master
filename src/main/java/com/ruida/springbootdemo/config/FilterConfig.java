package com.ruida.springbootdemo.config;

import com.ruida.springbootdemo.filter.GlobalRequestFilter;
import com.ruida.springbootdemo.filter.InputFilter;
import com.ruida.springbootdemo.filter.LoginFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: 过滤器配置
 * @author: chenjy
 * @create: 2020-06-18 15:05
 */
@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean inputFilterRegister(){
        FilterRegistrationBean register = new FilterRegistrationBean();
        register.setFilter(new InputFilter());
        register.setOrder(1);//多个filter时，通过order设置优先级。值越小，优先级越高。
        register.addUrlPatterns("*");
        register.setName("inputFitler");
        register.setEnabled(true);
        return register;
    }

    @Bean
    public FilterRegistrationBean loginFilterRegister(){
        FilterRegistrationBean register = new FilterRegistrationBean();
        register.setFilter(new LoginFilter());
        register.setOrder(2);
        register.addUrlPatterns("/login");
        register.setName("loginFitler");
        register.setEnabled(true);
        return register;
    }

    @Bean
    public FilterRegistrationBean globalReuestFilterRegister(){
        FilterRegistrationBean register = new FilterRegistrationBean();
        register.setFilter(new GlobalRequestFilter());
        register.setOrder(3);//多个filter时，通过order设置优先级。值越小，优先级越高。
        register.addUrlPatterns("*");
        register.setName("globalRequestFilter");
        register.setEnabled(false);
        return register;
    }

}
