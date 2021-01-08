package com.ruida.springbootdemo.test;

import com.ruida.springbootdemo.enums.ChannelRuleEnum;
import com.ruida.springbootdemo.utils.rule.GeneralChannelRule;

/**
 * @description:
 * @author: chenjy
 * @create: 2021-01-08 13:36
 */
public class TestChannelEnum {
    public static void main(String[] args) {
        String name = "TENCENT";
        ChannelRuleEnum channelRuleEnum = ChannelRuleEnum.match(name);
        GeneralChannelRule channel = channelRuleEnum.getChannel();
        channel.process();
    }
}
