package com.ruida.springbootdemo.service.order;

import com.aliyun.openservices.ons.api.Message;
import com.ruida.springbootdemo.core.mq.consumer.MQConsumeService;
import com.ruida.springbootdemo.core.mq.consumer.MQConsumer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import java.nio.charset.StandardCharsets;

/**
 * @author chenjy
 * @date 2021/3/12
 */
@Slf4j
@Component
@MQConsumer(groupId = "GID_order_group_", topic = "topic-order-status", tag = "tag-order-status-")
public class OrderConsumer implements MQConsumeService{

    @Override
    public boolean consume(Message message) {
        try {
            log.info("消息主题->{},消息key->{},消息内容->{}", message.getTopic(), message.getKey(), new String(message.getBody(), StandardCharsets.UTF_8));
            return true;
        } catch (Exception e) {
            log.error("消息消费异常->消息主题->{},消息key->{},消息内容->{},ex{}", message.getTopic(), message.getKey(), new String(message.getBody(), StandardCharsets.UTF_8), e);
            return false;
        }
    }
}
