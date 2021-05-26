package com.ruida.springbootdemo.annotation;

import java.lang.annotation.*;

/**
 * @author overmind
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Alpha {

    String value() default "";

    String name() default "";

    int status() default 0;

    //注解的成员变量只能使用基本数据类型、String、Enum；不能使用Integer等包装类型，需注意
    //Integer deleted() default 1;
}
