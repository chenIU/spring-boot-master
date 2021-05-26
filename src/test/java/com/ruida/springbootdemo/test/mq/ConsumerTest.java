package com.ruida.springbootdemo.test.mq;

import com.aliyun.openservices.ons.api.*;

import java.util.Properties;

/**
 * @author chenjy
 * @date 2021/3/12
 */
public class ConsumerTest {
    public static void main(String[] args) {
        Properties properties = new Properties();
        // 您在控制台创建的Group ID。
        properties.put(PropertyKeyConst.GROUP_ID, "GID_order_group_dev");
        // AccessKey ID阿里云身份验证，在阿里云RAM控制台创建。
        properties.put(PropertyKeyConst.AccessKey, "");
        // Accesskey Secret阿里云身份验证，在阿里云服RAM控制台创建。
        properties.put(PropertyKeyConst.SecretKey, "");
        // 设置TCP接入域名，进入控制台的实例详情页面的TCP协议客户端接入点区域查看。
        properties.put(PropertyKeyConst.NAMESRV_ADDR, "");
        // 集群订阅方式(默认)。
        // properties.put(PropertyKeyConst.MessageModel, PropertyValueConst.CLUSTERING);
        // 广播订阅方式。
        // properties.put(PropertyKeyConst.MessageModel, PropertyValueConst.BROADCASTING);

        Consumer consumer = ONSFactory.createConsumer(properties);
        consumer.subscribe("TopicTestMQ", "TagA||TagB", new MessageListener() { //订阅多个Tag。
            public Action consume(Message message, ConsumeContext context) {
                System.out.println("Receive: " + message);
                return Action.CommitMessage;
            }
        });

        //订阅另外一个Topic，如需取消订阅该Topic，请删除该部分的订阅代码，重新启动消费端即可。
        consumer.subscribe("topic_order_status_dev", "*", new MessageListener() { //订阅全部Tag。
            public Action consume(Message message, ConsumeContext context) {
                System.out.println("Receive: " + message);
                return Action.CommitMessage;
            }
        });

        consumer.start();
        System.out.println("Consumer Started");
    }
}
