package com.ruida.springbootdemo.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ruida.springbootdemo.model.Book;

import java.util.List;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-12-18 13:27
 */
public class FastJsonTest {
    public static void main(String[] args) {
        //language=JSON
        String jsonstr = "{\n" +
                "  \"id\":1,\n" +
                "  \"name\":\"三国演义\",\n" +
                "  \"author\":\"罗贯中\"\n" +
                "}";
        System.out.println(jsonstr);
        Book book = JSON.parseObject(jsonstr,Book.class);//直接解析为Java对象
        System.out.println(book);

        JSONObject json = (JSONObject) JSON.parse(jsonstr);//解析成JSON对象
        System.out.println(json);

        Book book1 = JSON.toJavaObject(json,Book.class);//JSON对象转为Java对象
        System.out.println(book1);

        JSON json1 = (JSON) JSON.toJSON(book);//Java对象转为JSON对象
        System.out.println(json1);

        JSON.toJSONString(book);//Java对象转为json类型的字符串

        //JSON数组
        //language=JSON
        String jsonArrStr = "[\n" +
                "  {\n" +
                "    \"id\":1,\n" +
                "    \"name\":\"三国演义\",\n" +
                "    \"author\":\"罗贯中\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\":2,\n" +
                "    \"name\":\"西游记\",\n" +
                "    \"author\":\"吴承恩\"\n" +
                "  }\n" +
                "]";

        System.out.println();
        System.out.println("========数组========");
        List<Book> bookList = JSON.parseArray(jsonArrStr,Book.class);//json字符串转为对象集合
        System.out.println(bookList);
        bookList.stream().forEach(System.out::println);

        JSONArray jsonArray = JSON.parseArray(jsonArrStr);//json数组字符串转为JSONArray对象
        System.out.println(jsonArray);
        jsonArray.stream().forEach(System.out::println);
    }
}
