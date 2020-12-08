package com.ruida.springbootdemo.test;

import com.ruida.springbootdemo.entity.Book;

import java.io.*;
import java.math.BigDecimal;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-11-26 11:58
 */
public class SerializableTest2 {
    public static void main(String[] args) throws IOException {
        Book book = new Book();
        book.setBookName("三国演义");
        book.setPrice(BigDecimal.valueOf(100));

        serialize(book);
    }

    public static void serialize(Book book) throws IOException {
        OutputStream os = new ObjectOutputStream(new FileOutputStream("book.txt"));
        ((ObjectOutputStream) os).writeObject(book);
        os.close();
        System.out.println("序列化完成...");

    }
}
