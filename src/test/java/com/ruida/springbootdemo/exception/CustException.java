package com.ruida.springbootdemo.exception;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-09-30 16:07
 */
public class CustException extends RuntimeException{

    private String errorCode;

    private String errorMsg;

    public CustException(){

    }

    public CustException(String errorCode,String errorMsg){
        super(errorMsg);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }
}
