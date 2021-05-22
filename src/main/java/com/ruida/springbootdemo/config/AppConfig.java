package com.ruida.springbootdemo.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chen.J.Y
 * @date 2021/5/22
 */
@Configuration
public class AppConfig {

    /**
     * fastjson 消息转换器
     */
    public static FastJsonHttpMessageConverter getFastJsonHttpMessageConverter(){

        //定义一个消息转换器
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();

        //添加FastJson配置信息
        FastJsonConfig fastJsonConfig = new FastJsonConfig();

        fastJsonConfig.setSerializerFeatures(
                //日期类型使用默认格式
                SerializerFeature.WriteDateUseDateFormat,
                //取消对象的循环引用
                SerializerFeature.DisableCircularReferenceDetect
        );
        converter.setFastJsonConfig(fastJsonConfig);

        //处理中文乱码问题
        List<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        converter.setSupportedMediaTypes(mediaTypes);

        return converter;

    }

}
