package com.ruida.springbootdemo.enums;

public enum ErrorEnum {

    E_10001("E_1001","客户端请求不合法",400);

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
