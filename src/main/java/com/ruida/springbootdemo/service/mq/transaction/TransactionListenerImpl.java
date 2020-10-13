package com.ruida.springbootdemo.service.mq.transaction;

import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import java.util.concurrent.ConcurrentHashMap;

public class TransactionListenerImpl implements TransactionListener {

    //key：事务id；value：状态(0：执行中；1：成功；2：失败)
    private ConcurrentHashMap<String,Integer> map = new ConcurrentHashMap();

    /**
     * 执行本地事务
     * @param message
     * @param o
     * @return
     */
    @Override
    public LocalTransactionState executeLocalTransaction(Message message, Object o) {
        String transactionId = message.getTransactionId();

        map.put(transactionId,0);

        //执行业务代码,service
        System.out.println("hello------transaction");

        try {
            System.out.println("正在执行本地事务------");
            Thread.sleep(1000*10);
            System.out.println("本地事务执行完毕------");
            map.put(transactionId,1);
        } catch (InterruptedException e) {
            e.printStackTrace();
            map.put(transactionId,2);
            return LocalTransactionState.ROLLBACK_MESSAGE;
        }
        return LocalTransactionState.COMMIT_MESSAGE;
    }

    /**
     * 消息回查
     * @param messageExt
     * @return
     */
    @Override
    public LocalTransactionState checkLocalTransaction(MessageExt messageExt) {

        String transactionId = messageExt.getTransactionId();
        Integer status = map.get(transactionId);
        System.out.println("消息回查---"+transactionId+",transactionId:"+transactionId+",status:"+status);
        switch (status){
            case 0:
                return LocalTransactionState.UNKNOW;
            case 1:
                return LocalTransactionState.COMMIT_MESSAGE;
            case 2:
                return LocalTransactionState.ROLLBACK_MESSAGE;
        }
        return LocalTransactionState.UNKNOW;
    }
}
