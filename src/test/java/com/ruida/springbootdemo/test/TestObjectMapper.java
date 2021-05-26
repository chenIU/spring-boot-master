package com.ruida.springbootdemo.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ruida.springbootdemo.entity.User;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 常用方法：
 * writeValueAsString
 * writeValueAsBytes
 * readValue(String jsonStr)
 * readValue(Byte[] bytes)
 * @author chenjy
 * @date 2021/3/15
 */
public class TestObjectMapper {
    private static ObjectMapper mapper = new ObjectMapper();

    @Test
    public void test() throws JsonProcessingException {
        Map<String,Object> map = new HashMap();
        map.put("age",10);
        map.put("username","jack");
        String str = mapper.writeValueAsString(map);
        System.out.println(str);
        byte[] bytes = mapper.writeValueAsBytes(map);
        System.out.println(bytes);

    }

    @Test
    public void test2() throws IOException {
        User user = new User("jack",18);

        /* ---------------- 写入 -------------- */
        String str = mapper.writeValueAsString(user);
        System.out.println(str);
        byte[] bytes = mapper.writeValueAsBytes(user);
        System.out.println(Arrays.toString(bytes));

        /* ---------------- 读取 -------------- */
        User user1 = mapper.readValue(bytes, User.class);
        System.out.println(user1);
        User user2 = mapper.readValue(str, User.class);
        System.out.println(user2);
    }
}
