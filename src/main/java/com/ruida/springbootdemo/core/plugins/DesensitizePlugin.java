package com.ruida.springbootdemo.core.plugins;

import com.ruida.springbootdemo.annotation.DesensitizeAnnotation;
import com.ruida.springbootdemo.enums.DesensitizationStrategy;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;
import java.util.stream.Stream;

/**
 * @author chenjy
 * @date 2021/3/6
 */
@Intercepts(@Signature(type = ResultSetHandler.class,method = "handleResultSets",args = Statement.class))
@Component
public class DesensitizePlugin implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        List<Object> records = (List<Object>) invocation.proceed();
        records.forEach(this::desensitized);
        return records;
    }

    private void desensitized(Object source) {
        Class<?> clazz = source.getClass();
        MetaObject metaObject = SystemMetaObject.forObject(source);
        Stream.of(clazz.getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(DesensitizeAnnotation.class))
                .forEach(field -> doDesensitization(metaObject,field));
    }

    private void doDesensitization(MetaObject metaObject, Field field) {
        String name = field.getName();
        Object value = metaObject.getValue(name);
        if(String.class == metaObject.getGetterType(name) || value != null){
            DesensitizeAnnotation annotation = field.getAnnotation(DesensitizeAnnotation.class);
            DesensitizationStrategy strategy = annotation.strategy();
            Object o = strategy.getDesensitization().apply((String) value);
            metaObject.setValue(name,o);
        }
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
