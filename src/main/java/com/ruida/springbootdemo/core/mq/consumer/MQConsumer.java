package com.ruida.springbootdemo.core.mq.consumer;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author chenjy
 * @date 2021/3/12
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MQConsumer {

    String groupId();

    String topic();

    String tag() default "*";

}
