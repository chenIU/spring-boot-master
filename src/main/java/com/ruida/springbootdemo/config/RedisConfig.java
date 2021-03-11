package com.ruida.springbootdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @description: redis配置类
 * @author: chenjy
 * @create: 2020-04-29 15:48
 */
@Configuration
public class RedisConfig {

    /**
     * RedisTemplate 序列化
     * 1.JdkSerializationRedisSerializer 序列化java对象（被序列化的对象必须实现Serializable接口）
     * 2.StringRedisSerializer 简单的字符串序列化
     * 3.JacksonJsonRedisSerializer 序列化object对象为json字符串
     * 4.Jackson2JsonRedisSerializer 跟JacksonJsonRedisSerializer实际上是一样的
     * 5.GenericToStringSerializer 类似StringRedisSerializer的字符串序列化
     * 6.GenericJackson2JsonRedisSerializer 类似Jackson2JsonRedisSerializer，但使用简单，不需要复杂的构造过程
     * @param connectionFactory 连接工厂
     * @return RedisTemplate对象
     */
    @Bean
    public RedisTemplate<Object,Object> redisTemplate(RedisConnectionFactory connectionFactory){
        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();

        redisTemplate.setConnectionFactory(connectionFactory);
        redisTemplate.setDefaultSerializer(new GenericJackson2JsonRedisSerializer());

        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringRedisSerializer);
        redisTemplate.setHashKeySerializer(stringRedisSerializer);

        //使用GenericToStringSerializer的原因是value两端没有引号，更便于复制
        redisTemplate.setValueSerializer(new GenericToStringSerializer<>(Object.class));

        return redisTemplate;
    }
}
