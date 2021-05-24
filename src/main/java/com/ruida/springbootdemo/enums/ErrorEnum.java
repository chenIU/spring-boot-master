package com.ruida.springbootdemo.enums;

public enum ErrorEnum {


    OK(0000,"操作成功",200),
    SERVER_ERR(500,"服务器繁忙",500),
    ERROR(1001,"操作失败",500),
    NO_DATA(1002,"无数据",200),
    E_10001(1003,"客户端请求不合法",400),

    /**
     * 常用参数校验
     */
    NO_PARAM(20101, "必填参数未填写",500),
    ILLEGAL_PARAM(20102,"参数无效",500),


    /*=============算数异常===========*/
    E_2001(2001,"数值不满足要求",400);

    private int errorCode;

    private String errorMsg;

    private int httpStatus;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(int httpStatus) {
        this.httpStatus = httpStatus;
    }

    ErrorEnum(int errorCode, String errorMsg, int httpStatus) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.httpStatus = httpStatus;
    }

}
