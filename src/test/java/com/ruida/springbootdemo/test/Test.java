package com.ruida.springbootdemo.test;

import com.ruida.springbootdemo.entity.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-05-18 15:23
 */
public class Test {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setName("jack");
        Student s2 = new Student();
        s2.setName("mike");
        List<Student> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        List<String> strList = list.stream().map(x -> x.getName()).collect(Collectors.toList());
        strList.forEach(System.out::println);

        List<Student> stuList = list.stream().map( x -> {
            x.setName("hello " + x.getName());
            return x;
        }).collect(Collectors.toList());
        stuList.forEach(System.out::println);
       /* Course course = new Course();
        course.setId(1);
        course.setName("暑期拔高课程");
        course.setAuthor("马云");
        course.setSubject("数学");
        CourseExt courseExt = new CourseExt();
        BeanUtils.copyProperties(course,courseExt);
        System.out.println(course);
        System.out.println(courseExt.getName());

        List<Course> list = new ArrayList<>();
        list.add(course);
        if(CollectionUtils.isEmpty(list)){
            System.out.println("list集合为空");
        }else {
            System.out.println("list集合不为空");
        }*/
    }

    public void say(String a,String prefix){
        System.out.println(prefix + a);
    }
}
