package com.ruida.springbootdemo.core.mq.producer;

import com.aliyun.openservices.ons.api.ONSFactory;
import com.aliyun.openservices.ons.api.Producer;
import com.aliyun.openservices.ons.api.PropertyKeyConst;
import com.ruida.springbootdemo.constant.SystemConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author chenjy
 * @date 2021/3/12
 */
@Slf4j
//@Component
public class ProducerListener implements ApplicationListener<ApplicationReadyEvent> {

    @Resource
    RocketMqConfig rocketMqConfig;

    private static final Map<String, Producer> producerMap = new HashMap<>();

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {

        String[] groupArray = SystemConstant.GID.split(",");
        if(groupArray.length == 0){
            throw new IllegalArgumentException("can not found valid configuration in properties file");
        }

        Properties properties = rocketMqConfig.getProperties();

        //初始化所有producer
        for (String groupId : groupArray){
            //设置groupId
            String realGroupId = MQUtil.getRealId(groupId);
            properties.setProperty(PropertyKeyConst.GROUP_ID,realGroupId);

            Producer producer = ONSFactory.createProducer(properties);
            producer.start();

            producerMap.put(realGroupId,producer);
            log.info("init producer groupId: {}",realGroupId);
        }
    }

    public Producer getProducer(String groupId){
        return producerMap.get(groupId);
    }
}
