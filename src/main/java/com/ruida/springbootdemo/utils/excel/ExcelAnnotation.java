package com.ruida.springbootdemo.utils.excel;

import com.ruida.springbootdemo.constant.SystemConstant;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ExcelAnnotation {
    String title();

    boolean require() default false;

    int scale() default -1;

    String dateFormat() default SystemConstant.DATE_FORMAT;

    int order() default 0;
}
