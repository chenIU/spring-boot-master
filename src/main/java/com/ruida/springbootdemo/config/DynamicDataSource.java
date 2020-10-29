package com.ruida.springbootdemo.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.Map;

/**
 * 动态切换数据源主要依靠AbstractRoutingDataSource
 * defaultTargetDataSource：默认目标数据源
 * targetDataSources(map类型)存放用来切换的数据源
 * @author: chenjy
 * @create: 2020-10-29 09:05
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    public DynamicDataSource(DataSource defaultTargetDataSource, Map<Object,Object> targetDataSource){
        super.setDefaultTargetDataSource(defaultTargetDataSource);
        super.setTargetDataSources(targetDataSource);
        super.afterPropertiesSet();
    }

    /**
     * 根据key获取数据源信息
     * @return
     */
    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSourceContextHolder.getDataSourceType();
    }
}
