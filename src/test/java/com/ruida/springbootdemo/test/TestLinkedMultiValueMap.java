package com.ruida.springbootdemo.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @desc 一个key存储多个value  可以替换Map<K,List<V>的数据结构
 * @author chenjy
 * @date 2021/3/10
 */
public class TestLinkedMultiValueMap {
    private LinkedMultiValueMap<String, String> map;

    @Before
    public void setUp() {
        map = new LinkedMultiValueMap<>();
    }

    @org.junit.Test
    public void add() {
        map.add("key", "value1");
        map.add("key", "value2");
        assertEquals(1, map.size());
        List<String> expected = new ArrayList<>(2);
        expected.add("value1");
        expected.add("value2");
        assertEquals(expected, map.get("key"));
    }

    @Test
    public void getFirst() {
        List<String> values = new ArrayList<>(2);
        values.add("value1");
        values.add("value2");
        map.put("key", values);
        assertEquals("value1", map.getFirst("key"));
        assertNull(map.getFirst("other"));
    }

    @org.junit.Test
    public void set() {
        map.set("key", "value1");
        map.set("key", "value2");
        assertEquals(1, map.size());
        assertEquals(Collections.singletonList("value2"), map.get("key"));
    }

    @org.junit.Test
    public void equals() {
        map.set("key1", "value1");
        assertEquals(map, map);
        MultiValueMap<String, String> o1 = new LinkedMultiValueMap<>();
        o1.set("key1", "value1");
        assertEquals(map, o1);
        assertEquals(o1, map);
        Map<String, List<String>> o2 = new HashMap<>();
        o2.put("key1", Collections.singletonList("value1"));
        assertEquals(map, o2);
        assertEquals(o2, map);
    }
}
