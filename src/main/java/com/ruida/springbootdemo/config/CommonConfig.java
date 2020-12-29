package com.ruida.springbootdemo.config;

import com.ruida.springbootdemo.entity.City;
import com.ruida.springbootdemo.entity.People;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-10-30 11:17
 */
@Configuration
public class CommonConfig {

    @Bean
    public City city(){
        City city = new City();
        city.setCityName("千岛湖");
        return city;
    }

    @Bean
    @ConditionalOnBean(name = "city")
    public People people(City city){
        People people = new People();
        people.setName("陈俭银");
        people.setAge(26);
        people.setCity(city);
        return people;
    }
}
