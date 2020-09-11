package com.ruida.springbootdemo.annotation;

import com.ruida.springbootdemo.enums.WeekdayEnum;

import java.lang.annotation.*;

@Target({ElementType.TYPE,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyAnnotation {

    String value();

    int order() default -1;

    WeekdayEnum[] week() default WeekdayEnum.SUNDAY;
}
