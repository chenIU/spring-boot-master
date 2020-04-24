package com.ruida.springbootdemo;

import com.ruida.springbootdemo.entity.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description: 对象工具类
 * @author: chenjy
 * @create: 2020-04-22 09:16
 */
public class ObjectUtil {

    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student();
        //System.out.println(s1.equals(s2));
        List<Integer> list = new ArrayList<>();
        list.add(100);
        list.add(80);
        list.add(55);
        list.add(15);
        list.add(30);
        List<Integer> result = list.stream()
                .filter(i->i>50)
                .sorted(Integer::compareTo)
                .collect(Collectors.toList());
        System.out.println(result);
        System.out.println(123);
        String s = "410609,410602";
        List<String> l = Arrays.asList(s.split(","));
        System.out.println(l);

    }

}
