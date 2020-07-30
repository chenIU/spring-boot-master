package com.ruida.springbootdemo.auth;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-07-30 14:47
 */
public class BaseContext {
    private static ThreadLocal<Map<String,Object>> threadLocal = new ThreadLocal<>();

    public static void set(String key,Object value){
        Map<String,Object> map = threadLocal.get();
        if(map == null){
            map = new HashMap<>();
            threadLocal.set(map);
        }
        map.put(key,value);
    }

    public static Object get(String key){
        Map<String,Object> map = threadLocal.get();
        if(map == null){
            map = new HashMap<>();
            threadLocal.set(map);
        }
        return map.get(key);
    }
}
