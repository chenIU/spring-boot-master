package com.ruida.springbootdemo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @description: 数据源
 * @author: chenjy
 * @create: 2020-03-30 16:00
 */
@Component
@ConfigurationProperties(prefix = "spring.datasource.db01")
public class DataSource {

    private String username;

    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
