package com.ruida.springbootdemo.bean;

import com.ruida.springbootdemo.enums.ErrorEnum;
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

    public CommonResult(ErrorEnum e){
        this.errorCode = e.getErrorCode();
        this.errorMsg = e.getErrorMsg();
    }

    public static <T> CommonResult<T> error(String errorCode,String errorMsg){
        CommonResult<T> error = new CommonResult<>();
        error.setErrorCode(errorCode);
        error.setErrorMsg(errorMsg);
        return error;
    }

    public static <T> CommonResult<T> OK(T t){
        CommonResult ok = new CommonResult();
        ok.setErrorCode("000000");
        ok.setErrorMsg("成功");
        ok.setContent(t);
        return ok;
    }
}
