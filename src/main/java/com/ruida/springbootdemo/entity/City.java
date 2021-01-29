package com.ruida.springbootdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-10-30 11:15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class City implements Comparable<City>{

    private String cityName;

    private Integer cityCode;

    @Override
    public int compareTo(City o) {
        //o1比o2升序排序,o2比o1降序排序
//        return this.cityCode.compareTo(o.getCityCode());
        return o.getCityCode().compareTo(this.cityCode);
    }
}
