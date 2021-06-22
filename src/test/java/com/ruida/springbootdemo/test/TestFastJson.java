package com.ruida.springbootdemo.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.ruida.springbootdemo.model.Book;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chen.J.Y
 * @date 2021/6/22
 */
public class TestFastJson {

    private static Book book;

    static {
        book = new Book();
        book.setId(1L);
        book.setName("三国演义");
        book.setAuthor("罗贯中");
    }

    /**
     * toJsonString 将JavaBean转换为JSON文本
     * 重载方法toJsonString(Object object, boolean prettyFormat)以美化形式输出
     */
    @Test
    public void testToJsonString() {
        System.out.println(JSONObject.toJSONString(book));

        ArrayList<Book> books = Lists.newArrayList(
                new Book(2L, "西游记", "吴承恩"),
                new Book(3L, "水浒传", "施耐庵"),
                new Book(4L, "红楼梦", "曹雪芹")
        );
        System.out.println(JSONObject.toJSONString(books));
    }

    /**
     * 将JavaBean转换成JSONObject或者JSONArray
     */
    @Test
    public void testToJson() {
        JSONObject jsonObject = (JSONObject) JSON.toJSON(book);
        System.out.println(jsonObject.get("id"));
        System.out.println(jsonObject.get("name"));
        System.out.println(jsonObject.get("author"));
    }

    @Test
    public void testParse() {
        String str = "{\"author\":\"罗贯中\",\"id\":1,\"name\":\"三国演义\"}";
        Object obj = JSONObject.parse(str);
        System.out.println(obj);
    }

    /**
     * parseObject 将JSON文本转换成JSONObject
     */
    @Test
    public void testParseObject() {
        String str = "{\"author\":\"罗贯中\",\"id\":1,\"name\":\"三国演义\"}";
        JSONObject jsonObject = JSONObject.parseObject(str);
        System.out.println(jsonObject.get("id"));
        System.out.println(jsonObject.get("name"));
        System.out.println(jsonObject.get("author"));
    }

    /**
     * parseObject 重载方法，在调用时传入转换对象的字节码
     */
    @Test
    public void testParseObject2() {
        String str = "{\"author\":\"罗贯中\",\"id\":1,\"name\":\"三国演义\"}";
        Book b = JSONObject.parseObject(str, Book.class);
        System.out.println(b);
    }

    /**
     * parseArray 将JSON文本转换成JSONArray
     */
    @Test
    public void testParseArray() {
        String books = "[{\"author\":\"吴承恩\",\"id\":2,\"name\":\"西游记\"},{\"author\":\"施耐庵\",\"id\":3,\"name\":\"水浒传\"},{\"author\":\"曹雪芹\",\"id\":4,\"name\":\"红楼梦\"}]";
        JSONArray jsonArray = JSONObject.parseArray(books);
        System.out.println(jsonArray.get(0));
    }

    /**
     * 重载方法 parse传入对象字节码，指定要转换成的对象类型
     */
    @Test
    public void testParseArray2() {
        String books = "[{\"author\":\"吴承恩\",\"id\":2,\"name\":\"西游记\"},{\"author\":\"施耐庵\",\"id\":3,\"name\":\"水浒传\"},{\"author\":\"曹雪芹\",\"id\":4,\"name\":\"红楼梦\"}]";
        List<Book> bookList = JSONObject.parseArray(books, Book.class);
        bookList.forEach(System.out::println);
    }
}
