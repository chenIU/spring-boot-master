package com.ruida.springbootdemo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @description: 数据源切换处理
 * @author: chenjy
 * @create: 2020-10-29 09:00
 */
public class DynamicDataSourceContextHolder {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(DynamicDataSourceContextHolder.class);

    private static final ThreadLocal<String> CONTEXT_HOLDER = new ThreadLocal<>();

    /**
     * 设置数据源变量
     * @param dataSourceType
     */
    public static void setDataSourceType(String dataSourceType){
        LOGGER.info("切换到{}数据源",dataSourceType);
        CONTEXT_HOLDER.set(dataSourceType);
    }

    /**
     * 获取数据源变量
     * @return
     */
    public static String getDataSourceType(){
        return CONTEXT_HOLDER.get();
    }

    /**
     * 清空数据源变量
     */
    public static void clearDataSourceType(){
        CONTEXT_HOLDER.remove();
    }
}
