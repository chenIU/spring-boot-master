package com.ruida.springbootdemo.reflect;

import com.ruida.springbootdemo.model.Book;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @description: 测试构造器
 * @author: chenjy
 * @create: 2021-01-04 09:23
 */
public class TestConstructor {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        //利用无参构造函数构造实例对象
        Constructor<Book> c1 = Book.class.getConstructor(null);
        Book book1 = c1.newInstance();
        System.out.println(book1);

        //利用有参构造函数构造实例对象
        Constructor<Book> c2 = Book.class.getConstructor(Long.class, String.class, String.class);
        Book book2 = c2.newInstance(1L,"战争与和平","列夫托尔斯泰");
        System.out.println(book2);

        //利用私有构造器构造实例对象
//        Constructor<Book> c3 = Book.class.getConstructor(String.class, String.class);
        Constructor<Book> c3 = Book.class.getDeclaredConstructor(String.class, String.class);
        //getConstructor和getDeclaredConstructor的区别

        c3.setAccessible(true);
        Book book3 = c3.newInstance("狂人日记", "鲁迅");
        System.out.println(book3);

    }
}
