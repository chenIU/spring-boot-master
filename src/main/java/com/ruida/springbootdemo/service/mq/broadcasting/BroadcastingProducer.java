package com.ruida.springbootdemo.service.mq.broadcasting;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class BroadcastingProducer {
    public static void main(String[] args) throws MQClientException, UnsupportedEncodingException, RemotingException, InterruptedException, MQBrokerException {
        //1.创建DefaultMQProducer
        DefaultMQProducer producer = new DefaultMQProducer("demo_producer_group");

        //2.设置Namesrv
        producer.setNamesrvAddr("192.168.127.133:9876");

        //3.开启DefaultMQProducer
        producer.start();

        //4.创建消息
        List<Message> messages = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Message message = new Message("Topic_Broadcasting_Demo",//主题
                    "Tag_demo",//标签，用于过滤消息
                    "Key"+i,   //消息的唯一值
                    ("hello"+i).getBytes(RemotingHelper.DEFAULT_CHARSET));
            messages.add(message);
        }

        //5.发送消息
        SendResult result = producer.send(messages);
        System.out.println(result);

        //6.关闭DefaultMQProducer
        producer.shutdown();
    }
}
