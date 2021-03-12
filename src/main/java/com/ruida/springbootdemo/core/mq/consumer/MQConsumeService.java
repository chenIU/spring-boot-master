package com.ruida.springbootdemo.core.mq.consumer;

import com.aliyun.openservices.ons.api.Message;

/**
 * @author chenjy
 * @date 2021/3/12
 */
public interface MQConsumeService {

    /**
     * 消息消费，成功返回true，失败返回false
     * @param message
     * @return
     */
    boolean consume(Message message);
}
