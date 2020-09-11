package com.ruida.springbootdemo.annotation;

import com.ruida.springbootdemo.enums.WeekdayEnum;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-09-11 08:42
 */
@MyAnnotation(value = "zhangsan",order = 1,week = {WeekdayEnum.FRIDAY,WeekdayEnum.MONDAY})
public class AnnotationDemo1 {
}
