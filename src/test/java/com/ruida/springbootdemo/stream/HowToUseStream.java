package com.ruida.springbootdemo.stream;

import com.google.common.collect.Lists;
import com.ruida.springbootdemo.model.Book;
import com.ruida.springbootdemo.model.BookVO;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-12-24 16:06
 */
public class HowToUseStream {

    public static void main(String[] args) {

        mapMethod();

    }

    public static void mapMethod(){

        //1.大小写字符转换
        List<String> charList = Arrays.asList("a","b","c","d");
        List<String> mapCharList = charList.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(mapCharList);

        //2.对数字进行相同的操作（对集合中的数字进行*2的操作）
        List<Integer> numberList = Arrays.asList(1,2,3,4);
        List<Integer> mapNumberList = numberList.stream().map(x -> x * 2).collect(Collectors.toList());
        System.out.println(mapNumberList);

        //3.对象列表->字符串列表
        List<Book> bookList = Lists.newArrayList(
                new Book(1L,"三国演义","罗贯中"),
                new Book(3L,"水浒传","施耐庵"),
                new Book(2L,"西游记","吴承恩"),
                new Book(4L,"红楼梦","曹雪芹")
        );

        List<String> mapBookList = bookList.stream().map(x -> x.getName()).collect(Collectors.toList());
        System.out.println(mapBookList);

        //4.List转Map

        //4.1 key是bookId，value是bookName
        Map<String, String> listToMap1 = bookList.stream().collect(Collectors.toMap(e -> String.valueOf(e.getId()), e -> e.getName()));
        System.out.println(listToMap1);

        //4.2 key是bookId，value是book对象
        Map<String, Book> listToMap2 = bookList.stream().collect(Collectors.toMap(e -> String.valueOf(e.getId()), e -> e));
        System.out.println(listToMap2);

        //4.3 bookList中的bookId重复时，List转Map会出现key重复异常(IllegalStateException)
        Book book  = new Book(4L,"红楼梦","曹雪芹");
        bookList.add(book);
//        Map<String, Book> listToMap3 = bookList.stream().collect(Collectors.toMap(e -> String.valueOf(e.getId()), e -> e));
//        System.out.println(listToMap3);

        //解决方法：添加一个BinaryOperator到toMap方法中，这也称为合并功能，比如如果重复，可以取第一个元素
        Map<String, Book> listToMap3 = bookList.stream().collect(Collectors.toMap(e -> String.valueOf(e.getId()), e -> e,(e1,e2) -> e1));
        System.out.println(listToMap3);

        //4.4 生成指定的Map
        TreeMap<Long, String> listToMap4 = bookList.stream().collect(Collectors.toMap(e -> e.getId(), e -> e.getName(), (e1, e2) -> e1, TreeMap::new));
        System.out.println(listToMap4);

        //5.一个对象转换成另一个对象
        List<BookVO> bookVOList = bookList.stream().map(e -> {
            BookVO bookVO = new BookVO();
            bookVO.setBookName(e.getName());
            bookVO.setAuthor(e.getAuthor());
            return bookVO;
        }).collect(Collectors.toList());
        bookVOList.stream().forEach(System.out::println);
    }
}
