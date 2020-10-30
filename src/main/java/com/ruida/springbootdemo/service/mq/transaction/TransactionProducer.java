package com.ruida.springbootdemo.service.mq.transaction;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.apache.rocketmq.client.producer.TransactionSendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.*;

public class TransactionProducer {
    public static void main(String[] args) throws MQClientException, UnsupportedEncodingException, RemotingException, InterruptedException, MQBrokerException {
        //1.创建DefaultMQProducer
        //DefaultMQProducer producer = new DefaultMQProducer("demo_producer_transaction_group");
        TransactionMQProducer producer = new TransactionMQProducer("demo_producer_transaction_group");

        //2.设置Namesrv
        producer.setNamesrvAddr("192.168.127.133:9876");

        //指定消息监听对象，用户执行本地事务和消息回查
        TransactionListener transactionListener = new TransactionListenerImpl();
        producer.setTransactionListener(transactionListener);

        //线程池
        ExecutorService executorService = new ThreadPoolExecutor(2,
                5,
                100,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(2000),
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        Thread thread = new Thread();
                        thread.setName("client-transaction-msg-check-thread");
                        return thread;
                    }
                });
        producer.setExecutorService(executorService);

        //3.开启DefaultMQProducer
        producer.start();

        //4.创建消息
        Message message = new Message("Topic_Transaction_Demo",//主题
                "Tag_demo",//标签，用于过滤消息
                "Key_1",   //消息的唯一值
                "transaction-demo".getBytes(RemotingHelper.DEFAULT_CHARSET));

        //5.发送事务消息
        //SendResult result = producer.send(message);
        TransactionSendResult result = producer.sendMessageInTransaction(message, "hello-transaction");
        System.out.println(result);

        //6.关闭DefaultMQProducer
        producer.shutdown();
    }
}
