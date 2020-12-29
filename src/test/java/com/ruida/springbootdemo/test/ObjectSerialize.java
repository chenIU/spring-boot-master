package com.ruida.springbootdemo.test;

import com.ruida.springbootdemo.entity.Employee;

import java.io.*;

/**
 * @description: 对象序列化和反序列化
 * @author: chenjy
 * @create: 2020-12-29 08:38
 */
public class ObjectSerialize {

    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.setEid(1);
        employee.setEname("马化腾");

        //序列化对象
        serialize(employee);

        //反序列化对象
        Employee employee1 = (Employee) deserialize();
        System.out.println(employee1);
    }

    private static void serialize(Object obj){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("E:\\employee.txt"));
            oos.writeObject(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Object deserialize(){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("E:\\employee.txt"));
            Object o = ois.readObject();
            return o;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
