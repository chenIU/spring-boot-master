package com.ruida.springbootdemo.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.ruida.springbootdemo.realm.AccountRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Hashtable;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Bean
    public AccountRealm accountRealm(){
        return new AccountRealm();
    }

    @Bean
    public DefaultWebSecurityManager securityManager(@Qualifier("accountRealm") AccountRealm accountRealm){
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(accountRealm);
        return manager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(securityManager);
        //权限设置
        Map<String,String> map = new Hashtable<>();
        map.put("/shiro/main","authc");
        map.put("/shiro/manage","perms[manage]");
        map.put("/shiro/administrator","roles[administrator]");
        factoryBean.setFilterChainDefinitionMap(map);

        //设置登录页面
        factoryBean.setLoginUrl("/shiro/login");

        //设置错误页面
        factoryBean.setUnauthorizedUrl("/unauth");
        return factoryBean;
    }

    @Bean
    public ShiroDialect shiroDialect(){
        return new ShiroDialect();
    }
}
