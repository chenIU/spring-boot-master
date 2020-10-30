package com.ruida.springbootdemo.entity.result;

import com.ruida.springbootdemo.enums.ErrorEnum;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @description: 通用返回结果
 * @author: chenjy
 * @create: 2020-04-03 08:57
 */
@Getter
@Setter
public class CommonResult implements Serializable {

    private static final long serialVersionUID = -2922415836378367968L;

    private static final String ERROR_CODE = "0";

    private boolean success;

    private String errorCode;

    private String errorMsg;

    public CommonResult() {
        this.success = true;
        this.errorCode = ERROR_CODE;
    }

    public CommonResult(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public CommonResult(ErrorEnum e){
        this.errorCode = e.getErrorCode();
        this.errorMsg = e.getErrorMsg();
    }

    public static <T extends CommonResult> T error(String errorCode,String errorMsg){
        CommonResult error = new CommonResult();
        error.setSuccess(false);
        error.setErrorCode(errorCode);
        error.setErrorMsg(errorMsg);
        return (T)error;
    }

    public static <T extends CommonResult> T OK(){
        CommonResult OK = new CommonResult();
        OK.setSuccess(false);
        OK.setErrorCode("000000");
        OK.setErrorMsg("成功");
        return (T)OK;
    }

    @Override
    public String toString() {
        return "CommonResult{" +
                "success=" + success +
                ", errorCode='" + errorCode + '\'' +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }
}
