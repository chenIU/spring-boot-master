package com.ruida.springbootdemo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-10-27 14:49
 */
public class MyInvocationHandler implements InvocationHandler {

    private Object object = null;

    public Object bind(Object target){
        this.object = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("请求方法:"+method.getName());
        System.out.println("请求参数:"+Arrays.asList(args));
        return method.invoke(object,args);
    }
}
