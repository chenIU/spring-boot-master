package com.ruida.springbootdemo.test;

import com.ruida.springbootdemo.entity.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description: 睿达测试
 * @author: chenjy
 * @create: 2020-04-17 09:27
 */
public class LambdaTest {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(()->{
            try {
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"jack",57));
        students.add(new Student(1,"mike",20));
        students.add(new Student(2,"amy",30));

        List<String> nameList = students.parallelStream()
                .filter(s->s.getId()==1)
                .sorted(Comparator.comparing(Student::getName))
                .map(Student::getName)
                .collect(Collectors.toList());

        System.out.println("stream:"+nameList.toString());
        System.out.println("学生集合排序之前"+students.toString());
        students.sort((s1,s2)->s1.getAge().compareTo(s2.getAge()));
        System.out.println("学生集合排序之后"+students.toString());

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(50);
        list.add(3);
        list.add(100);
        list.add(40);
        System.out.println("排序之前："+list.toString());

        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        System.out.println("排序之后："+list.toString());

        list.sort(Integer::compareTo);
        System.out.println("排序之后："+list.toString());

    }

}
