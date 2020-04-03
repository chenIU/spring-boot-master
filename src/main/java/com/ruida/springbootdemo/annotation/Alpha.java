package com.ruida.springbootdemo.annotation;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Alpha {

    String value() default "";

    String name() default "";

}
