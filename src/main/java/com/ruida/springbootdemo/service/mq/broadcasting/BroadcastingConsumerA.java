package com.ruida.springbootdemo.service.mq.broadcasting;

import lombok.SneakyThrows;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.util.List;

public class BroadcastingConsumerA {

    public static void main(String[] args) throws MQClientException {

        //1.创建DefaultMQPushConsumer
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("demo_consumer_group");

        //2.设置Namesrv地址
        consumer.setNamesrvAddr("192.168.127.133:9876");

        //设置消息拉取最大数
        consumer.setConsumeMessageBatchMaxSize(2);

        //默认是集群消费方式(一个消息只能由一个消费者消费)
        consumer.setMessageModel(MessageModel.BROADCASTING);

        //3.设置subscribe
        consumer.subscribe("Topic_Broadcasting_Demo","*");

        //4.创建消息监听
        consumer.setMessageListener(new MessageListenerConcurrently() {
            @SneakyThrows
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {

                //5.获取消费消息
                for (MessageExt msg : list) {

                    //主题
                    String topic = msg.getTopic();

                    //标签
                    String tags = msg.getTags();

                    //消息内容
                    String result = new String(msg.getBody(), RemotingHelper.DEFAULT_CHARSET);

                    System.out.println("A---Consumer消费消息------topic:"+topic+",tags:"+tags+",result:"+result);
                }

                //6.返回消息读取状态
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });

        //开启消费者
        consumer.start();
    }


}
