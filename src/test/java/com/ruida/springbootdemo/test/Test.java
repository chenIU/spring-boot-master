package com.ruida.springbootdemo.test;

import com.ruida.springbootdemo.entity.Course;
import com.ruida.springbootdemo.entity.CourseExt;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-05-18 15:23
 */
public class Test {
    public static void main(String[] args) {
        Course course = new Course();
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
        }
    }
}
