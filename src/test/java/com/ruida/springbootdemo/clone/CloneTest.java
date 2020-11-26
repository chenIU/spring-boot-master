package com.ruida.springbootdemo.clone;

/**
 * @description:
 * 浅拷贝：对于值类型，直接复制值；对于引用类型，复制引用地址，不重新重建对象
 * 深拷贝：对于值类型，直接复制值；对于引用类型，创建新的对象
 * Cloneable接口拷贝默认是浅拷贝
 * @author: chenjy
 * @create: 2020-11-26 11:15
 */
public class CloneTest {

    public static void main(String[] args) throws CloneNotSupportedException {
        Major major = new Major();
        major.setMajorName("计算机科学与技术");
        major.setMajorId(1);

        Student s1 = new Student();
        s1.setName("陈俭银");
        s1.setAge(26);
        s1.setMajor(major);

        Student s2 = (Student) s1.clone();
        System.out.println(s1 == s2);
        System.out.println(s1);
        System.out.println(s2);

        s1.setAge(30);
        major.setMajorName("通信技术");
        System.out.println(s1);
        System.out.println(s2);
    }
}
