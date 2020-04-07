package com.ruida.springbootdemo.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @description: map遍历
 * @author: chenjy
 * @create: 2020-04-07 09:11
 */
public class MapUtil {
    public static void main(String[] args) {
        Map<String,Object> map = new HashMap();
        map.put("name","chenjianyin");
        map.put("school","lit");
        map.put("age",26);

        Iterator<Map.Entry<String, Object>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry entry = iterator.next();
            String key = (String) entry.getKey();
            Object value = entry.getValue();
            System.out.println("key="+key+",value="+value);
        }
        System.out.println("==================================");
        Set<Map.Entry<String, Object>> set = map.entrySet();
        Iterator it = set.iterator();
        while(it.hasNext()){
            Map.Entry entry = (Map.Entry) it.next();
            String key = (String) entry.getKey();
            Object value = entry.getValue();
            System.out.println("key="+key+",value="+value);
        }
        System.out.println("==================================");
        Iterator keySet = map.keySet().iterator();
        while (keySet.hasNext()){
            String key = (String) keySet.next();
            Object value = map.get(key);
            System.out.println("key="+key+",value="+value);
        }
        System.out.println("==================================");
        Set s = map.keySet();
        Iterator<String> i = s.iterator();
        while (i.hasNext()){
            String key = i.next();
            Object value = map.get(key);
            System.out.println("key="+key+",value="+value);
        }
    }
}
