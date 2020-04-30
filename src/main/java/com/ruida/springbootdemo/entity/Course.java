package com.ruida.springbootdemo.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @description: 课程表
 * @author: chenjy
 * @create: 2020-04-29 13:36
 */
@Entity
@Table(name = "t_course")
@Data
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "course_name",length = 32)
    private String name;

    @Column(length = 128)
    private String author;

    @Column(length = 32)
    private String subject;

}
