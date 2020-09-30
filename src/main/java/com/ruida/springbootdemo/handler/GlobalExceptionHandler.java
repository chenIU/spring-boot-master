package com.ruida.springbootdemo.handler;

import com.ruida.springbootdemo.entity.result.CommonResult;
import com.ruida.springbootdemo.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * ResponseStatus http请求状态码 200、404、502等
 * @description: 全局异常处理
 * @author: chenjy
 * @create: 2020-04-03 09:01
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 验证异常
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    public CommonResult handleMethodArgumentNotValidException(HttpServletRequest request, MethodArgumentNotValidException e){
        CommonResult result = new CommonResult();
        BindingResult bindingResult = e.getBindingResult();

        StringBuffer sb = new StringBuffer("Invalid Request:\n");

        for(FieldError fieldError : bindingResult.getFieldErrors()){
            sb.append(fieldError.getDefaultMessage());
            sb.append("\n");
        }

        result.setErrorMsg(sb.toString());
        result.setErrorCode("500");
        return result;
    }

    /**
     * 业务异常
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(BizException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public CommonResult bizExceptionHandler(BizException e){
        //log.error("业务异常={}", JSONObject.toJSON(e));
        CommonResult commonResult = new CommonResult(e.getErrorCode(),e.getErrorMsg());
        return commonResult;
    }

    /**
     * 普通异常
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public CommonResult exceptionHandler(Exception e){
        //log.error("普通异常={}", JSONObject.toJSON(e));
        CommonResult commonResult = new CommonResult(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()),"操作失败");
        return commonResult;
    }

}
