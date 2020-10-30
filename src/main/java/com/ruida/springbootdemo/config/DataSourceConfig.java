package com.ruida.springbootdemo.config;

import com.ruida.springbootdemo.enums.DataSourceType;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 数据源注入
 * @author: chenjy
 * @create: 2020-10-29 09:08
 */
@Configuration
public class DataSourceConfig {

    @Bean
    @ConfigurationProperties("spring.datasource.druid.master")
    public DataSource masterDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.druid.slave")
    @ConditionalOnProperty(prefix = "spring.datasource.druid.slave", name = "enabled", havingValue = "true")
    public DataSource slaveDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean("dynamicDataSource")
    @Primary
    public DynamicDataSource dataSource(DataSource masterDataSource,DataSource slaveDataSource){
        Map<Object,Object> targetDataSource = new HashMap<>();
        targetDataSource.put(DataSourceType.MASTER.name(),masterDataSource);
        targetDataSource.put(DataSourceType.SLAVE.name(),slaveDataSource);
        return new DynamicDataSource(masterDataSource,targetDataSource);
    }
}
