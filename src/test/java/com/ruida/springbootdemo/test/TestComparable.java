package com.ruida.springbootdemo.test;

import com.google.common.collect.Lists;
import com.ruida.springbootdemo.entity.City;
import java.util.Collections;
import java.util.List;

/**
 * @author chenjy
 * @since 2021/1/29 8:42
 */
public class TestComparable {
    public static void main(String[] args) {
        List<City> cityList = Lists.newArrayList(
                new City("南京",300001),
                new City("杭州",600001),
                new City("北京",100001),
                new City("武汉",400001)
        );

        Collections.sort(cityList);
        System.out.println(cityList);
    }
}
