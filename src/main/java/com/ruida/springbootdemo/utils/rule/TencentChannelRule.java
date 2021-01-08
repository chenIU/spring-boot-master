package com.ruida.springbootdemo.utils.rule;

/**
 * @description:
 * @author: chenjy
 * @create: 2021-01-08 13:26
 */
public class TencentChannelRule extends GeneralChannelRule{
    @Override
    public void process() {
        //腾讯处理逻辑
        System.out.println("腾讯渠道处理...");
    }
}
