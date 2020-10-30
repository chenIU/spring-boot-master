package com.ruida.springbootdemo.service.mq.quickstart;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;
import java.io.UnsupportedEncodingException;

public class Producer {
    public static void main(String[] args) throws MQClientException, UnsupportedEncodingException, RemotingException, InterruptedException, MQBrokerException {
        //1.创建DefaultMQProducer
        DefaultMQProducer producer = new DefaultMQProducer("demo_producer_group");

        //2.设置Namesrv
        producer.setNamesrvAddr("192.168.127.133:9876");

        //3.开启DefaultMQProducer
        producer.start();

        //4.创建消息
        Message message = new Message("Topic_demo",//主题
                "Tag_demo",//标签，用于过滤消息
                "Key_1",   //消息的唯一值
                "hello".getBytes(RemotingHelper.DEFAULT_CHARSET));

        //5.发送消息
        SendResult result = producer.send(message);
        System.out.println(result);

        //6.关闭DefaultMQProducer
        producer.shutdown();
    }
}
