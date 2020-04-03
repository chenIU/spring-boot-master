package com.ruida.springbootdemo.beans;

import lombok.Data;

import java.io.Serializable;

/**
 * @description: 通用返回结果
 * @author: chenjy
 * @create: 2020-04-03 08:57
 */
@Data
public class CommonResult<T> implements Serializable {

    private T content;

    private String errorCode;

    private String errorMsg;

    public CommonResult() {

    }

    public CommonResult(T content, String errorCode, String errorMsg) {
        this.content = content;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public CommonResult(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

}
