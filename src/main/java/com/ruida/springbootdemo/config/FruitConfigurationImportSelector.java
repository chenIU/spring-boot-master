package com.ruida.springbootdemo.config;

import com.ruida.springbootdemo.entity.fruit.Apple;
import com.ruida.springbootdemo.entity.fruit.Banana;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @description:
 * @author: chenjy
 * @create: 2021-01-15 08:58
 */
public class FruitConfigurationImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{Apple.class.getName(), Banana.class.getName()};
    }
}
