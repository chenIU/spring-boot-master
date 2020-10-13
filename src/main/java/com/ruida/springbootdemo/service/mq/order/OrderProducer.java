package com.ruida.springbootdemo.service.mq.order;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.io.UnsupportedEncodingException;
import java.util.List;

public class OrderProducer {
    public static void main(String[] args) throws MQClientException, UnsupportedEncodingException, RemotingException, InterruptedException, MQBrokerException {
        //1.创建DefaultMQProducer
        DefaultMQProducer producer = new DefaultMQProducer("demo_producer_order_group");

        //2.设置Namesrv
        producer.setNamesrvAddr("192.168.127.133:9876");

        //3.开启DefaultMQProducer
        producer.start();

        //5.发送消息
        //MessageQueueSelector 传入所有队列
        //arg 指定某个队列
        for (int i = 0; i < 5; i++) {
            //4.创建消息
            Message message = new Message("Topic_Order_Demo",//主题
                    "Tags_Demo",//标签，用于过滤消息
                    "Key_1"+i,   //消息的唯一值
                    ("hello_"+i).getBytes(RemotingHelper.DEFAULT_CHARSET));
            SendResult result = producer.send(message, new MessageQueueSelector() {
                @Override
                public MessageQueue select(List<MessageQueue> list, Message message, Object o) {
                    Integer index = (Integer) o;
                    return list.get(index);
                }
            },0);
            System.out.println(result);
        }

        //6.关闭DefaultMQProducer
        producer.shutdown();
    }
}
