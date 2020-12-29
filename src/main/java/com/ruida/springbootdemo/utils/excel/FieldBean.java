package com.ruida.springbootdemo.utils.excel;

import com.ruida.springbootdemo.utils.excel.processor.TypeProcessor;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-12-25 10:21
 */
public class FieldBean<T> implements Comparable<FieldBean>{

    boolean require;

    String title;

    int order;

    Method setMethod;

    Method getMethod;

    TypeProcessor typeProcessor;

    public void setInvoke(T instance, String preValue, String title) throws ParseException, InvocationTargetException, IllegalAccessException {
        if(require){
            if(StringUtils.isBlank(preValue)){
                throw new ParseException(title + "不能为空",0);
            }
        }
        Object value = typeProcessor.fromString(preValue);
        setMethod.invoke(instance,value);
    }

    public String getInvoke(T instance) throws InvocationTargetException, IllegalAccessException, ParseException {
        Object value = getMethod.invoke(instance);
        return typeProcessor.toString(value);
    }

    public boolean isRequire() {
        return require;
    }

    public void setRequire(boolean require) {
        this.require = require;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public Method getSetMethod() {
        return setMethod;
    }

    public void setSetMethod(Method setMethod) {
        this.setMethod = setMethod;
    }

    public Method getGetMethod() {
        return getMethod;
    }

    public void setGetMethod(Method getMethod) {
        this.getMethod = getMethod;
    }

    public TypeProcessor getTypeProcessor() {
        return typeProcessor;
    }

    public void setTypeProcessor(TypeProcessor typeProcessor) {
        this.typeProcessor = typeProcessor;
    }

    @Override
    public int compareTo(FieldBean o) {
        return Integer.valueOf(this.getOrder()).compareTo(Integer.valueOf(o.getOrder()));
    }
}
