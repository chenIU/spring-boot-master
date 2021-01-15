package com.ruida.springbootdemo.annotation;

import com.ruida.springbootdemo.config.FruitConfigurationImportSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
//@Import({Apple.class, Banana.class})
@Import(FruitConfigurationImportSelector.class)
public @interface EnableFruitConfiguration {

}
