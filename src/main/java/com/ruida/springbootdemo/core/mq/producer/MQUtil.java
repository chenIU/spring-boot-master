package com.ruida.springbootdemo.core.mq.producer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author chenjy
 * @date 2021/3/12
 */
@Component
public class MQUtil {

    private static String env;

    @Value("${spring.profiles.active}")
    public void setEnv(String env) {
        MQUtil.env = env;
    }

    /**
     * 得到不同环境的groupId
     * @param groupId
     * @return
     */
    public static String getRealId(String groupId) {
        return groupId + env;
    }
}
