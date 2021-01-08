package com.ruida.springbootdemo.utils.rule;

/**
 * @description:
 * @author: chenjy
 * @create: 2021-01-08 13:27
 */
public class ByteDanceChannelRule extends GeneralChannelRule{
    @Override
    public void process() {
        //字节跳动处理
        System.out.println("字节渠道处理...");
    }
}
