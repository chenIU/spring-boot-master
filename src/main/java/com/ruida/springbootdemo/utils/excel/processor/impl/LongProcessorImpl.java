package com.ruida.springbootdemo.utils.excel.processor.impl;

import com.ruida.springbootdemo.utils.excel.processor.TypeProcessor;
import org.apache.commons.lang3.StringUtils;
import java.text.ParseException;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-12-25 14:45
 */
public class LongProcessorImpl implements TypeProcessor {
    @Override
    public Object fromString(String preValue) throws ParseException {
        if(StringUtils.isBlank(preValue)){
            return 0L;
        }
        try {
            return Long.parseLong(preValue);
        }catch (NumberFormatException e){
            throw new ParseException(preValue + "无法转换为Long数字类型",0);
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
