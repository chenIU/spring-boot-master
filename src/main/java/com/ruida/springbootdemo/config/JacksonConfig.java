package com.ruida.springbootdemo.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ruida.springbootdemo.serializer.modifier.CustomizeBeanSerializerModifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

/**
 * @description: 序列化对象属性值为null特殊处理
 * @author: chenjy
 * @create: 2021-01-08 15:46
 */
//@Configuration
public class JacksonConfig {

    @Bean
    @Primary
    @ConditionalOnMissingBean(ObjectMapper.class)
    public ObjectMapper jacksonObjectMapper(Jackson2ObjectMapperBuilder builder){
        ObjectMapper objectMapper = builder.createXmlMapper(false).build();
        objectMapper.setSerializerFactory(objectMapper.getSerializerFactory().withSerializerModifier(new CustomizeBeanSerializerModifier()));
        return objectMapper;
    }

}
