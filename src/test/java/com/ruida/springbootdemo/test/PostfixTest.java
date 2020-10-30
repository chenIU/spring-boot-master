package com.ruida.springbootdemo.test;

import com.ruida.springbootdemo.entity.Book;
import org.junit.Test;
import org.slf4j.Logger;
import java.util.ArrayList;
import java.util.List;
import static org.slf4j.LoggerFactory.getLogger;

public class PostfixTest {

    private static final Logger log = getLogger(PostfixTest.class);

    private static Book b;

    public static void main(String[] args) {

        //1.变量创建
        Book book = new Book();//.var

        b = new Book();//.field

        Book book1 = new Book();//.new.var

        Book book2 = (Book) new Object();//.cast

        Book book3 = (Book) new Object();//.castvar

        //2.各种类型的判断
        if (book == null) {
            //.null
        }

        if (book != null) {
            //.notnull
        }

        if (book != null) {
            //.nn
        }

        boolean flag = true;
        if (flag) {
            //flag.if
        }

        while (flag) {
            //flag.while
        }

        //flag.not
        //!flag;

        //3.输出和返回
        System.out.println(flag);//flag.sout

        //flag.return
        //return flag;

        //4.循环
        String[] books = new String[5];
        for (int i = 0; i < books.length; i++) {
            //books.fori
        }

        for (String s : books) {
            //book.for
        }

        for (int i = books.length - 1; i >= 0; i--) {
            //book.forr
        }

        //5.异常捕获
        try {
            main(new String[3]);//main().try
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Inject Language
        String json = "{\"username\":\"chenjy\",\"age\": 27}";

        List<Book> list =new ArrayList<>();
    }

    //Live Template(Ctrl+J)

    @Test
    public void test111(){

    }
}
