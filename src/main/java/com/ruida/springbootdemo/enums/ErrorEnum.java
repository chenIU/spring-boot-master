package com.ruida.springbootdemo.enums;

import lombok.Getter;

@Getter
public enum ErrorEnum {

    OK(0000,"操作成功"),
    SERVER_ERR(500,"服务器繁忙"),
    ERROR(1001,"操作失败"),
    NO_DATA(1002,"无数据"),
    E_10001(1003,"客户端请求不合法"),

    /**
     * 常用参数校验
     */
    NO_PARAM(20101, "必填参数未填写"),
    ILLEGAL_PARAM(20102,"参数无效"),


    /*=============算数异常===========*/
    E_2001(2001,"数值不满足要求");

    private int errorCode;

    private String errorMsg;

    ErrorEnum(int errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }
}
