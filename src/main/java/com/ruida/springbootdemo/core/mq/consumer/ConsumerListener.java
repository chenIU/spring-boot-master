package com.ruida.springbootdemo.core.mq.consumer;

import com.aliyun.openservices.ons.api.Action;
import com.aliyun.openservices.ons.api.Consumer;
import com.aliyun.openservices.ons.api.ONSFactory;
import com.aliyun.openservices.ons.api.PropertyKeyConst;
import com.google.common.collect.Lists;
import com.ruida.springbootdemo.core.mq.producer.MQUtil;
import com.ruida.springbootdemo.core.mq.producer.RocketMqConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.reflections.Reflections;
import org.reflections.scanners.TypeAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import java.util.Set;

/**
 * @author chenjy
 * @date 2021/3/12
 */
@Slf4j
//@Component
public class ConsumerListener implements ApplicationListener<ApplicationReadyEvent>, ApplicationContextAware {

    @Value("${spring.profiles.active}")
    private String profile;

    @Resource
    private RocketMqConfig rocketMqConfig;

    private ApplicationContext applicationContext;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        Reflections reflections = new Reflections(new ConfigurationBuilder().setUrls(ClasspathHelper.forPackage("com.ruida.springbootdemo.service")).setScanners(new TypeAnnotationsScanner()));
        Set<Class<?>> classes = reflections.getTypesAnnotatedWith(MQConsumer.class, true);

        for (Class<?> clazz : classes) {
            MQConsumer annotation = clazz.getDeclaredAnnotation(MQConsumer.class);
            String groupId = MQUtil.getRealId(annotation.groupId());
            String topic = annotation.topic();
            String tag = annotation.tag() + profile;

            if (!Lists.newArrayList(clazz.getInterfaces()).contains(MQConsumeService.class)) {
                throw new IllegalArgumentException(clazz.getName() + " must implements MQConsumeService interface");
            }

            Consumer consumer = initConsumer(groupId);

            MQConsumeService mqConsumeService = (MQConsumeService) applicationContext.getBean(StringUtils.uncapitalize(clazz.getSimpleName()));

            log.info("subscribe consumer,groupId->[{}],topic->[{}],tag->[{}]", groupId, topic, tag);

            consumer.subscribe(topic, tag, (message, consumeContext) -> {
                try {
                    if (message.getReconsumeTimes() > 16) {
                        log.warn("Reconsume:{} message:{}", message, message.getBody() == null ? "" : new String(message.getBody(), StandardCharsets.UTF_8));
                    } else {
                        log.info("{} message:{}", message, message.getBody() == null ? "" : new String(message.getBody(), StandardCharsets.UTF_8));
                    }

                    boolean res = mqConsumeService.consume(message);
                    if (res) {
                        return Action.CommitMessage;
                    } else {
                        return Action.ReconsumeLater;
                    }
                } catch (Exception e) {
                    log.error("consume message error {}", message, e);
                    return Action.ReconsumeLater;
                }
            });

            try {
                consumer.start();
            } catch (Exception e) {
                log.error("consume error", e);
                throw new IllegalArgumentException(clazz.getName() + " fail to start");
            }
        }
    }

    private Consumer initConsumer(String groupId) {
        Properties properties = rocketMqConfig.getProperties();
        properties.put(PropertyKeyConst.GROUP_ID, groupId);

        return ONSFactory.createConsumer(properties);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
