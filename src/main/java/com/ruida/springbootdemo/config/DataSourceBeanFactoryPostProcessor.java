package com.ruida.springbootdemo.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author chenjy
 * @date 2021/3/6
 */
@Component
public class DataSourceBeanFactoryPostProcessor implements BeanDefinitionRegistryPostProcessor {
    public static final String DATA_SOURCE_INITIALIZER_POST_PROCESSOR = "dataSourceInitializerPostProcessor";

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
        /**
         * MyBatisAutoConfiguration会自动注册一个dataSourceInitializerPostProcessor 导致引入动态数据源的是时候查找其他数据源，
         * 但是创建完成之后通过dataSourceInitializerPostProcessor处理会导致循环依赖
         * dynamicDataSource->sourceDataSource->dataSourceInitializerPostProcessor->DataSourceInitializerInvoker
         * ->dynamicDataSource循环依赖
         */
        if (beanDefinitionRegistry.containsBeanDefinition(DATA_SOURCE_INITIALIZER_POST_PROCESSOR)) {
            beanDefinitionRegistry.removeBeanDefinition(DATA_SOURCE_INITIALIZER_POST_PROCESSOR);
        }
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

    }
}
