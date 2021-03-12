package com.ruida.springbootdemo.core.mq.producer;

import com.aliyun.openservices.ons.api.PropertyKeyConst;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @author chenjy
 * @date 2021/3/12
 */
@Configuration
public class RocketMqConfig {
    public Properties getProperties(){
        Properties properties = new Properties();

        properties.setProperty("AccessKey","");

        properties.setProperty("SecretKey","");

        //设置超时时间为3000毫秒
        properties.setProperty(PropertyKeyConst.SendMsgTimeoutMillis,"3000");
        //设置TCP接入地址
        properties.put(PropertyKeyConst.NAMESRV_ADDR,"");

        // 顺序消息消费失败进行重试前的等待时间，单位(毫秒)
        properties.put(PropertyKeyConst.SuspendTimeMillis,"100");

        // 消息消费失败时的最大重试次数
        properties.put(PropertyKeyConst.MaxReconsumeTimes,"20");
        return properties;
    }
}
