package com.ruida.springbootdemo.core.validator;

import com.ruida.springbootdemo.annotation.InEnum;
import com.ruida.springbootdemo.annotation.IntArrayValuable;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author chenjy
 * @since 2021/2/25 15:47
 */
public class InEnumValidator implements ConstraintValidator<InEnum,Integer> {

    private Set<Integer> values;

    @Override
    public void initialize(InEnum constraintAnnotation) {
        IntArrayValuable[] values = constraintAnnotation.value().getEnumConstants();
        if(values.length == 0){
            this.values = Collections.emptySet();
        }else {
            this.values = Arrays.stream(values[0].array()).boxed().collect(Collectors.toSet());
        }
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if(values.contains(value)){
            return true;
        }
        // 禁用默认的 message 的值
        context.disableDefaultConstraintViolation();
        // 重新添加错误提示语句
        context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate()
                .replaceAll("\\{value}", values.toString())).addConstraintViolation();
        return false;
    }
}
