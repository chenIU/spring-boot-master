package com.ruida.springbootdemo.annotation;

import com.ruida.springbootdemo.core.validator.InEnumValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author chenjy
 * @since 2021/2/25 15:43
 */
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = InEnumValidator.class)
public @interface InEnum {

    Class<? extends IntArrayValuable> value();

    String message() default "必须在指定范围内{value}";

    /**
     * @return 分组
     */
    Class<?>[] groups() default {};

    /**
     * @return Payload 数组
     */
    Class<? extends Payload>[] payload() default {};

    /**
     *  Defines several {@code @InEnum} constraints on the same element.
     */
    @Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER,ElementType.TYPE_USE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List {

        InEnum[] value();

    }
}
