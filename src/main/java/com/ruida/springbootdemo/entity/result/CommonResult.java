package com.ruida.springbootdemo.entity.result;

import com.ruida.springbootdemo.enums.ErrorEnum;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.Objects;

/**
 * @description: 通用返回结果
 * @author: chenjy
 * @create: 2020-04-03 08:57
 */
@Getter
@Setter
public class CommonResult<T> implements Serializable {

    private static final long serialVersionUID = -2922415836378367968L;

    private int code;

    private String msg;

    private T data;

    public CommonResult() {
        this.code = ErrorEnum.OK.getErrorCode();
        this.msg = ErrorEnum.OK.getErrorMsg();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommonResult<?> that = (CommonResult<?>) o;
        return code == that.code && Objects.equals(msg, that.msg) && Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, msg, data);
    }

    @Override
    public String toString() {
        return "CommonResult{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public static <T> CommonResult<T> build(ErrorEnum errorEnum, T data) {
        return build(errorEnum.getErrorCode(), errorEnum.getErrorMsg(), data);
    }

    public static <T> CommonResult<T> build(ErrorEnum errorEnum) {
        return build(errorEnum.getErrorCode(), errorEnum.getErrorMsg(), null);
    }

    public static <T> CommonResult<T> build(ErrorEnum errorEnum, String msg) {
        return build(errorEnum.getErrorCode(), msg, null);
    }

    public static <T> CommonResult<T> build(ErrorEnum errorEnum, String msg, T data) {
        return build(errorEnum.getErrorCode(), msg, data);
    }

    public static <T> CommonResult<T> build(int code, String msg) {
        return build(code, msg, null);
    }

    public static <T> CommonResult<T> build(int code, String msg, T data) {
        CommonResult<T> response = new CommonResult<>();
        response.setCode(code);
        response.setMsg(msg);
        response.setData(data);
        return response;
    }

    public static <T> CommonResult<T> success() {
        return build(ErrorEnum.OK);
    }

    public static <T> CommonResult<T> success(T data) {
        return build(ErrorEnum.OK.getErrorCode(), ErrorEnum.OK.getErrorMsg(), data);
    }
}
