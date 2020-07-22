package com.ruida.springbootdemo.mapper;

import com.ruida.springbootdemo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @description: 课程dao
 * @author: chenjy
 * @create: 2020-04-29 14:02
 */
public interface CourseDao extends JpaRepository<Course,Integer> {

    @Query(nativeQuery = true,value = "select * from t_course c where c.id = :id")
    Course selectById(@Param(value = "id") Integer id);

}
