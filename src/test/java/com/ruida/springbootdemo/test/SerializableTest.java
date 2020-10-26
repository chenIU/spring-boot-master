package com.ruida.springbootdemo.test;

import com.ruida.springbootdemo.entity.Student;
import java.io.*;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-10-26 13:25
 */
public class SerializableTest {
    public static void main(String[] args) throws IOException {
        Student student = new Student();
        student.setId(1);
        student.setName("chenjy");
        student.setAge(26);

        System.out.println("read before serializable");
        System.out.println(student);

        //序列化
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("E:/student.txt"));
            oos.writeObject(student);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            oos.close();
        }

        //反序列化
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("E:/student.txt"));
            student= (Student) ois.readObject();
            System.out.println("read after serializable");
            System.out.println(student);
            /**
             * 被transient修饰的属性不能被序列化
             * 静态变量不管是否被transient修饰是,都不能被序列化.
             */
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            ois.close();
        }
    }
}
