package com.ruida.springbootdemo.clone;

import com.ruida.springbootdemo.entity.BaseInfo;
import com.ruida.springbootdemo.entity.Blog;
import org.junit.Test;

import java.util.Date;

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

    @Test
    public void test1() throws CloneNotSupportedException {
        BaseInfo baseInfo = new BaseInfo();
        baseInfo.setCreateTime(new Date());
        baseInfo.setCreateBy(10001);
        Blog blog = new Blog(1,"百度","http://www.baidu.com",baseInfo);
        System.out.println(blog);
        Blog cloneObject = (Blog) blog.clone();
        System.out.println(cloneObject);

//        blog.setId(2);
        baseInfo.setCreateBy(10002);

        //总结：Object.clone()默认是浅拷贝。即对于基础数据类型,拷贝的是值,对于引用类型,拷贝的是对象的引用(没有创建新的对象)
        //深浅拷贝的区别：看是否创建了新的对象 深拷贝(创建了新的对象)、浅拷贝(没有创建新的对象)
        System.out.println(blog);
        System.out.println(cloneObject);
    }
}
