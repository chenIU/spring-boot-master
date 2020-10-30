package com.ruida.springbootdemo.service.mq.order;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.io.UnsupportedEncodingException;
import java.util.List;

public class OrderConsumer {

    public static void main(String[] args) throws MQClientException {

        //1.创建DefaultMQPushConsumer
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("demo_consumer_order_group");

        //2.设置Namesrv地址
        consumer.setNamesrvAddr("192.168.127.133:9876");

        //设置消息拉取最大数
        consumer.setConsumeMessageBatchMaxSize(2);

        //3.设置subscribe
        consumer.subscribe("Topic_Order_Demo", "*");

        //4.创建消息监听
        consumer.setMessageListener(new MessageListenerOrderly() {
            @Override
            public ConsumeOrderlyStatus consumeMessage(List<MessageExt> list, ConsumeOrderlyContext consumeOrderlyContext) {
                //5.获取消费消息
                for (MessageExt msg : list) {
                    try {
                        //主题
                        String topic = msg.getTopic();

                        //标签
                        String tags = msg.getTags();

                        //消息内容
                        String result = new String(msg.getBody(), RemotingHelper.DEFAULT_CHARSET);

                        System.out.println("Order---Consumer消费消息------topic:" + topic + ",tags:" + tags + ",result:" + result);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                        return ConsumeOrderlyStatus.SUSPEND_CURRENT_QUEUE_A_MOMENT;
                    }

                }

                //6.返回消息读取状态
                return ConsumeOrderlyStatus.SUCCESS;
            }
        });

        //开启消费者
        consumer.start();
    }


}
