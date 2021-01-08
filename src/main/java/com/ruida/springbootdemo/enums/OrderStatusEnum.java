package com.ruida.springbootdemo.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

/**
 * @description: 订单状态
 * @author: chenjy
 * @create: 2021-01-07 17:30
 */
@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum OrderStatusEnum {

    TBP(1,"待支付"),
    CLOSED(3,"取消支付"),
    PAID(2,"支付成功"),
    REFUND(4,"退款");

    private final Integer code;

    private final String message;

    OrderStatusEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
