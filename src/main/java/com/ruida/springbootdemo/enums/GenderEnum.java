package com.ruida.springbootdemo.enums;

import com.ruida.springbootdemo.annotation.IntArrayValuable;
import lombok.Getter;

import java.util.Arrays;

/**
 * @author chenjy
 * @since 2021/2/25 15:39
 */
@Getter
public enum GenderEnum implements IntArrayValuable {
    MALE(1,"男"),
    FEMALE(2,"女");

    public static final int[] ARRAYS = Arrays.stream(values()).mapToInt(GenderEnum::getValue).toArray();

    private final Integer value;

    private final String name;

    GenderEnum(Integer value, String name) {
        this.value = value;
        this.name = name;
    }

    @Override
    public int[] array() {
        return  ARRAYS;
    }
}
