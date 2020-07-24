package com.ruida.springbootdemo.exception;

import com.ruida.springbootdemo.enums.ErrorEnum;

/**
 * @description: 异常类
 * @author: chenjy
 * @create: 2020-03-30 10:06
 */
public class BizException extends RuntimeException {

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

    public BizException(){
        super();
    }

    public BizException(String errorCode,String errorMsg){
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public BizException(String errorCode, String errorMsg, int httpStatus){
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.httpStatus = httpStatus;
    }

    public BizException(ErrorEnum errorEnum){
        this.errorCode = errorEnum.getErrorCode();
        this.errorMsg = errorEnum.getErrorMsg();
        this.httpStatus = errorEnum.getHttpStatus();
    }

}
