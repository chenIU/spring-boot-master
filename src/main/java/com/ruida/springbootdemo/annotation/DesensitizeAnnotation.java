package com.ruida.springbootdemo.annotation;

import com.ruida.springbootdemo.enums.DesensitizationStrategy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author chenjy
 * @date 2021/3/6
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DesensitizeAnnotation {

    DesensitizationStrategy strategy();
}
