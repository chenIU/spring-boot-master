package com.ruida.springbootdemo.enums;

import com.ruida.springbootdemo.utils.rule.ByteDanceChannelRule;
import com.ruida.springbootdemo.utils.rule.GeneralChannelRule;
import com.ruida.springbootdemo.utils.rule.TencentChannelRule;

public enum ChannelRuleEnum {

    TENCENT("TENCENT",new TencentChannelRule()),
    BYTEDANCE("BYTEDANCE",new ByteDanceChannelRule());

    private String name;

    private GeneralChannelRule channel;

    ChannelRuleEnum(String name, GeneralChannelRule channel) {
        this.name = name;
        this.channel = channel;
    }

    public static ChannelRuleEnum match(String name){
        ChannelRuleEnum[] values = ChannelRuleEnum.values();
        for(ChannelRuleEnum item:values){
            if(item.getName().equals(name)){
                return item;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public GeneralChannelRule getChannel() {
        return channel;
    }
}
