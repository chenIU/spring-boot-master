package com.ruida.springbootdemo.config;

import com.ruida.springbootdemo.entity.Org;
import com.ruida.springbootdemo.entity.Unit;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-11-02 16:15
 */
//@Configuration
@Component
public class BeanConfig {

    @Bean
    public Org org(){
        return new Org();
    }

    @Bean
    public Unit unit(){
        Unit unit = new Unit();
        unit.setOrg(org());
        return unit;
    }
}
