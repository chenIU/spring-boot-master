package com.ruida.springbootdemo.core.plugins;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.TypeHandlerRegistry;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 * @author chenjy
 * @date 2021/3/7
 */
@Intercepts({
        @Signature(type = Executor.class , method = "query" , args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}),
        @Signature(type = Executor.class , method = "update", args = {MappedStatement.class, Object.class})
})
@Component
@Slf4j
public class SqlPlugin implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
        Object parameters = invocation.getArgs()[1];
        BoundSql boundSql = mappedStatement.getBoundSql(parameters);
        Configuration configuration = mappedStatement.getConfiguration();

        Object result;
        long start = System.currentTimeMillis();
        try {
            result = invocation.proceed();
        }finally {
            long end = System.currentTimeMillis();
            if(log.isInfoEnabled()){
                log.info("time cost of execute SQL：{} ms",(end - start));
                String sql = getSql(configuration,boundSql);
                log.info("executed SQL：{}",sql);
            }
        }
        return result;
    }

    private String getSql(Configuration configuration, BoundSql boundSql) {
        String sql = boundSql.getSql();
        if(sql == null || sql.length() == 0){
            return "";
        }
        sql = beautifySql(sql);

        //将?替换成真正的参数
        Object parameterObject = boundSql.getParameterObject();
        List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
        if(!parameterMappings.isEmpty() && parameterObject != null){
            //类型处理器
            TypeHandlerRegistry typeHandlerRegistry = configuration.getTypeHandlerRegistry();
            //基本类型
            if(typeHandlerRegistry.hasTypeHandler(parameterObject.getClass())){
                sql = replaceSql(sql,parameterObject);
            }else {
                //对象
                MetaObject metaObject = configuration.newMetaObject(parameterObject);
                for(ParameterMapping parameterMapping : parameterMappings){
                    String property = parameterMapping.getProperty();
                    if(metaObject.hasGetter(property)){
                        Object value = metaObject.getValue(property);
                        sql = replaceSql(sql,value);
                    }else if(boundSql.hasAdditionalParameter(property)){
                        //动态属性名
                        Object additionalParameter = boundSql.getAdditionalParameter(property);
                        sql = replaceSql(sql,additionalParameter);
                    }
                }
            }
        }
        return sql;
    }

    private String replaceSql(String sql, Object parameterObject) {
        String result;
        if(parameterObject instanceof String){
            result = "'" + parameterObject + "'";
        }else if(parameterObject instanceof Date){
            result = "'" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(parameterObject) + "'";
        }else {
            result = parameterObject.toString();
        }
        return sql.replaceFirst("\\?",result);
    }

    private String beautifySql(String sql) {
        //待优化
        return sql.replaceAll("[\\s\n]+", " ");
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
