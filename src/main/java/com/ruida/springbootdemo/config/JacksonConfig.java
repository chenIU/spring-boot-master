package com.ruida.springbootdemo.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ruida.springbootdemo.core.serializer.modifier.CustomizeBeanSerializerModifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

/**
 * @description: 序列化对象属性值为null特殊处理
 * @author: chenjy
 * @create: 2021-01-08 15:46
 */
@Configuration
@ConditionalOnProperty(prefix = "customize.null-value",name = "enable",havingValue = "true")
//prefix：配置文件中的前缀
//name：配置的名字
//havingValue：与配置值的对比值,当两个值相同返回true,配置类生效
//matchIfMissing：缺省时是否生效
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
