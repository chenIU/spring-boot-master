package com.ruida.springbootdemo.exception;

import com.ruida.springbootdemo.enums.ErrorEnum;

/**
 * @description: 异常类
 * @author: chenjy
 * @create: 2020-03-30 10:06
 */
public class BaseException extends RuntimeException {

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

    @Override
    public String getMessage() {
        return this.errorMsg;
    }

    public BaseException(){
        super();
    }

    public BaseException(String errorCode, String errorMsg){
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public BaseException(String errorCode, String errorMsg, int httpStatus){
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.httpStatus = httpStatus;
    }

    public BaseException(ErrorEnum errorEnum){
        this.errorCode = errorEnum.getErrorCode();
        this.errorMsg = errorEnum.getErrorMsg();
        this.httpStatus = errorEnum.getHttpStatus();
    }

    /**
     *
     * 自定义异常不再爬取堆栈，提高性能
     */
    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
