package com.ruida.springbootdemo.enums;

import com.ruida.springbootdemo.core.plugins.Desensitization;
import lombok.Getter;

/**
 * @desc 脱敏策略
 * @author chenjy
 * @date 2021/3/6
 */
@Getter
public enum DesensitizationStrategy {
    /**
     * 姓名信息脱敏
     */
    USERNAME(s -> s.replaceAll("(\\w)(\\w)(\\w)*","$1*"))
    ;

    private final Desensitization desensitization;

    DesensitizationStrategy(Desensitization desensitization) {
        this.desensitization = desensitization;
    }
}
