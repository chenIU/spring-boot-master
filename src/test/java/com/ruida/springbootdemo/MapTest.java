package com.ruida.springbootdemo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @description: map测试类
 * <p>
 *     集合在遍历时，如果对集合元素进行增删操作，会抛出ConcurrentModificationException
 * </p>
 * @author: chenjy
 * @create: 2020-04-28 10:08
 */
public class MapTest {
    public static void main(String[] args) {
        Map<String,Object> map = new HashMap();
        map.put("name","chenjy");
        map.put("age",21);
        map.put("height",1.72);
        Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
        while(it.hasNext()){
            map.remove("name");
            Map.Entry entry = it.next();
            String key = (String) entry.getKey();
            Object value = entry.getValue();
            System.out.println("key=="+key+";value=="+value);
        }
    }
}
