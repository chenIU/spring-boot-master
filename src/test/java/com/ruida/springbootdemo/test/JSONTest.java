package com.ruida.springbootdemo.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ruida.springbootdemo.model.JSONmodel;

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
         * 第二部分： josn字符串-->bean
         */
        JSONmodel model = JSONObject.parseObject(jsonStr,JSONmodel.class);
        System.out.println(model);
        System.out.println(model.getName());

        /**
         * 第三部分：bean对象转json字符串
         */
        // JSONObject.toJSONString可以将bean对象抓换为json字符串
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
    }
}
