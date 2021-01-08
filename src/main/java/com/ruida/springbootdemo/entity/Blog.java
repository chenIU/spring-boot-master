package com.ruida.springbootdemo.entity;

import lombok.*;

/**
 * @description: 博客
 * 使用@Data模式@EqualsAndHashCode(callsuper=false)
 * callsuper=false表示对象在比较时不会考虑父类对象中的属性,仅仅比较子类中的属性
 * callsuper=true在比较时会考虑父类中的属性,通过父类和子类中的属性一起判断是否相等
 * @author: chenjy
 * @create: 2020-06-12 09:03
 */
@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Blog implements Cloneable{

    private int id;

    private String name;

    private String url;

    private BaseInfo baseInfo;

    public Blog(int id, String name, String url) {
        this.id = id;
        this.name = name;
        this.url = url;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
