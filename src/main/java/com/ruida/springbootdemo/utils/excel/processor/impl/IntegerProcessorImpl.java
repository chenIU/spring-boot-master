package com.ruida.springbootdemo.utils.excel.processor.impl;

import com.ruida.springbootdemo.utils.excel.processor.TypeProcessor;
import org.apache.commons.lang3.StringUtils;
import java.text.ParseException;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-12-25 14:48
 */
public class IntegerProcessorImpl implements TypeProcessor {
    @Override
    public Object fromString(String preValue) throws ParseException {
        if(StringUtils.isBlank(preValue)){
            return 0;
        }
        try {
            return Integer.parseInt(preValue);
        }catch (NumberFormatException e){
            throw new ParseException(preValue + "无法转换为Int数字类型",0);
        }
    }

    @Override
    public String toString(Object value) throws ParseException {
        if(value == null){
            return "";
        }
        return value.toString();
    }
}
