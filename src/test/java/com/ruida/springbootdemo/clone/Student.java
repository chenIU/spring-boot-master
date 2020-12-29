package com.ruida.springbootdemo.clone;

import lombok.Data;

import java.io.*;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-11-26 11:14
 */
@Data
public class Student implements Cloneable,Serializable{

    private String name;

    private int age;

    private Major major;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        //深拷贝实现方式一
//        Student student = (Student) super.clone();
//        Major major = (Major) this.major.clone();
//        student.major = major;

        //深拷贝实现方式二（利用序列化和反序列化），使用这种方式需要注意的是Student和Major都需要实现序列化接口
        try {
            //将对象本身序列化到字节流
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(byteArrayOutputStream);
            oos.writeObject(this);

            //再将字节流反序列化得到对象副本
            ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
            return ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
