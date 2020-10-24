package com.ruida.springbootdemo.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;

/**
 * 数据库字段和枚举类型字段映射
 * 1.注解(@EnumValue)
 * 2.实现IEnum接口
 */
public enum StatusEnum implements IEnum<Integer> {

    ON(1,"上架"),
    OFF(0,"下架")
    ;

    //@EnumValue
    private Integer code;

    private String msg;

    StatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public Integer getValue() {
        return this.code;
    }
}
