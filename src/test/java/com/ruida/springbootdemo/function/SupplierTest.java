package com.ruida.springbootdemo.function;

import com.ruida.springbootdemo.entity.Student;

import java.util.function.Supplier;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-09-28 09:13
 */
public class SupplierTest {

    public static void main(String[] args) {
        Supplier<String> supplier = () -> "hello world";
        System.out.println(supplier.get());

        System.out.println("-----------");
        Supplier<Student> supplier1 = Student::new;
        System.out.println(supplier1.get().getName());
    }
}
