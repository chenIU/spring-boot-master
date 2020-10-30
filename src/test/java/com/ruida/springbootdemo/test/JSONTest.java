package com.ruida.springbootdemo.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.ruida.springbootdemo.entity.User;
import com.ruida.springbootdemo.model.JSONmodel;

/**
 * 1.fastjson中的序列化和反序列化
 *  1.1序列化：将Java对象转换为JSON String或JSON Bytes
 *  1.2反序列化：将JSON String或JSON Bytes转换为Java对象
 * 2.fastjson默认根据fieldName的字母进行序列化，这样做的原因是为反序列化做准备(提升性能)
 */
public class JSONTest {

    public static void main(String[] args) {
        /**
         * 第一部分：json字符串-->JSONObject或者JSONArray
         */

        // JSONObject.parseObject方法将json字符串转换为json对象
        String jsonStr = "{\"name\":\"chenjainyin\",\"id\":27}";
        JSONObject json = JSONObject.parseObject(jsonStr);
        System.out.println(json);

        // JSONArray.parseArray方法将jonsArray类型的字符串，转换为json数组
        String array = "[{\"names\":[\"mike\",\"jack\",\"amy\"]}]";
        JSONArray jsonArray = JSONArray.parseArray(array);
        System.out.println(jsonArray);

        /**
         * 第二部分： json字符串-->bean
         */
        JSONmodel model = JSONObject.parseObject(jsonStr,JSONmodel.class);
        System.out.println(model);
        System.out.println(model.getName());

        /**
         * 第三部分：bean对象转json字符串
         */
        // JSONObject.toJSONString可以将bean对象抓换为json字符串SerializeWriter
        String str = JSONObject.toJSONString(model);
        System.out.println(str);

        // 美化
        String pretty = JSONObject.toJSONString(model,true);
        System.out.println(pretty);

        /**
         * 第四部分：java对象转换为JSONObject或者JSONArray
         */
        // JSONObject.toJSON可以将java对象转换为JSONObject对象
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(model);
        System.out.println(jsonObject);
        System.out.println(jsonObject.get("name"));


        System.out.println("=======================");
        User user = new User();
        user.setUsername("chenjy");
        user.setAge(26);
        System.out.println(JSON.toJSONString(user, SerializerFeature.WriteMapNullValue));//WriteMapNullValue：null字段也展示
    }
}
