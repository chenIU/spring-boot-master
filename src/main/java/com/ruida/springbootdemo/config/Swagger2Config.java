package com.ruida.springbootdemo.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @description:we
 * @author: chenjy
 * @create: 2020-04-27 16:24
 */
@Configuration
@EnableSwagger2
@EnableKnife4j
@Import(BeanValidatorPluginsConfiguration.class)
public class Swagger2Config {

    private boolean enable;

    @Value("${swagger.enable:false}")
    private void setEnable(boolean enable){
        this.enable = enable;
    }

    @Value("${server.port}")
    private String port;

    @Bean(value = "defaultApi2")
    public Docket defaultApi2(Environment env) {
        Profiles profiles = Profiles.of("dev");
        boolean flag = env.acceptsProfiles(profiles);

        Docket docket=new Docket(DocumentationType.SWAGGER_2)
                .enable(flag)
                .apiInfo(apiInfo())
                //分组名称
                .groupName("2.X版本")
                .select()
                //这里指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.ruida.springbootdemo.controller"))
                .paths(PathSelectors.any())
                .build().securityContexts(Lists.newArrayList(securityContext(),securityContext1())).securitySchemes(Lists.<SecurityScheme>newArrayList(apiKey(),apiKey1()));

        return docket;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("swagger-bootstrap-ui RESTful APIs")
                .description("swagger-bootstrap-ui")
                .termsOfServiceUrl("http://localhost:"+port+"/")
                .contact("developer@mail.com")
                .version("1.0")
                .build();
    }

    private ApiKey apiKey() {
        return new ApiKey("BearerToken", "Authorization", "header");
    }
    private ApiKey apiKey1() {
        return new ApiKey("BearerToken1", "Authorization-x", "header");
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(new ArrayList<>())
                .forPaths(PathSelectors.regex("/.*"))
                .build();
    }
    private SecurityContext securityContext1() {
        return SecurityContext.builder()
                .securityReferences(new ArrayList<>())
                .forPaths(PathSelectors.regex("/.*"))
                .build();
    }
}
