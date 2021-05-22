package com.ruida.springbootdemo.config;

import com.ruida.springbootdemo.interceptor.GlobalInterceptor;
import com.ruida.springbootdemo.interceptor.JwtInterceptor;
import com.ruida.springbootdemo.interceptor.LoginInterceptor;
import com.ruida.springbootdemo.utils.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import java.io.File;
import java.util.List;

/**
 * @description: web配置
 * @author: chenjy
 * @create: 2020-04-01 09:55
 */
@Component
@Slf4j
public class WebMvcConfig implements WebMvcConfigurer {

    @Value("${cors}")
    private String cors;

    @Autowired
    private JwtInterceptor jwtInterceptor;
    @Autowired
    private GlobalInterceptor globalInterceptor;
    @Autowired
    private LoginInterceptor loginInterceptor;

    /**
     * 此方法可以控制资源访问
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("doc.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");

        //定义静态资源访问路径和
        //addResourceHandler是指通过url请求的路径
        //addResourceLocations是图片存放的真实路径
        registry.addResourceHandler("/" + FileUtil.STATIC_DIR + "/**")
                .addResourceLocations("file:" + FileUtil.getStaticDir() + File.separator);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor).addPathPatterns("/auth/**");
        registry.addInterceptor(globalInterceptor).addPathPatterns("/market/**");
        //registry.addInterceptor(loginInterceptor).addPathPatterns("/login/**");

        //国际化
        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
        interceptor.setParamName("lang");
        registry.addInterceptor(interceptor);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        if(Boolean.valueOf(cors)){
            //log.warn("open cors...");
            registry.addMapping("/**")
                    .allowedOrigins("http://localhost:8081")
                    .allowedHeaders("*")
                    .allowedMethods("*")
                    .maxAge(30 * 1000);//有效时间，针对探测请求(PUT)
        }
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        WebMvcConfigurer.super.extendMessageConverters(converters);

        //使用FastJson消息转换器
//        converters.clear();
//        converters.add(AppConfig.getFastJsonHttpMessageConverter());
    }
}
