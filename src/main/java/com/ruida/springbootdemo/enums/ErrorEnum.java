package com.ruida.springbootdemo.enums;

public enum ErrorEnum {


    OK("0000","操作成功",200),
    SERVER_ERR("500","服务器繁忙",500),
    ERROR("1001","操作失败",500),
    NO_DATA("1002","无数据",200),
    E_10001("1003","客户端请求不合法",400),


    /*=============算数异常===========*/
    E_2001("2001","数值不满足要求",400);

    private String errorCode;

    private String errorMsg;

    private int httpStatus;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
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

    ErrorEnum(String errorCode, String errorMsg, int httpStatus) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.httpStatus = httpStatus;
    }

}
