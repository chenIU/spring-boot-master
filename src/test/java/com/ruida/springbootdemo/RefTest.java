package com.ruida.springbootdemo;

import com.ruida.springbootdemo.entity.Student;

/**
 * @description: 引用传递测试
 * <p>
 *     实参传递给形参的是参数，对于堆内存上的引用地址实参和形参在内存上指向了同一块区域，对形参的修改会影响实参。
 * </p>
 * @author: chenjy
 * @create: 2020-04-28 10:21
 */
public class RefTest {
    public static void main(String[] args) {
        Student student = new Student("jack",58);
        changeAge(student);
        System.out.println(student.getAge());//100
    }

    private static void changeAge(Student student){
        student.setAge(100);
    }
}
