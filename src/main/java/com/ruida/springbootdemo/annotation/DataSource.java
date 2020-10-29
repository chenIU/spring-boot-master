package com.ruida.springbootdemo.annotation;

import com.ruida.springbootdemo.enums.DataSourceType;

import java.lang.annotation.*;

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {

    /*
     * 切换数据源名称
     */
    DataSourceType value() default DataSourceType.MASTER;
}
