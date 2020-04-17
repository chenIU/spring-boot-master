package com.ruida.springbootdemo.utils;

import com.ruida.springbootdemo.entity.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class StringUtilTest {

    public static void main(String[] args) {

        List<Student> list = new ArrayList<>();
        list.add(new Student("jack",11));
        list.add(new Student("Mike",21));
        list.add(new Student("john",11));
        list.add(new Student("tom",28));

        Map<Integer, List<Student>> map = list.stream().collect(Collectors.groupingBy(Student::getAge));
        System.out.println(map.toString());
    }

}