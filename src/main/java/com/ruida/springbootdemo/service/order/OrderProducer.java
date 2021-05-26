package com.ruida.springbootdemo.service.order;

import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.SendResult;
import com.ruida.springbootdemo.core.mq.producer.MQUtil;
import com.ruida.springbootdemo.core.mq.producer.ProducerListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author chenjy
 * @date 2021/3/12
 */
@Slf4j
@Component
public class OrderProducer {

    private ProducerListener producerListener;

    @Autowired(required = false)
    public void setProducerListener(ProducerListener producerListener){
        this.producerListener = producerListener;
    }

    @Value("${spring.profiles.active}")
    private String profile;

    public boolean send(Integer orderId){
        try {
            Message message = new Message();
            message.setTopic("topic-order-status");
            message.setStartDeliverTime(System.currentTimeMillis() + 1000);
            message.setTag("tag-order-status-" + profile);
            message.setKey("orderId-" + orderId);
            message.setBody("订单状态消息".getBytes());
            SendResult result = producerListener.getProducer(MQUtil.getRealId("GID_order_group_")).send(message);
            if(result != null){
                log.info("消息发送成功:[{}]",orderId);
                return true;
            }

        }catch (Exception e){
            e.printStackTrace();
            log.error("消息发送失败:[{}]",orderId);
        }
        return false;
    }
}
