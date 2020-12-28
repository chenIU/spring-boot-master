package com.ruida.springbootdemo.utils.excel.processor.impl;

import com.ruida.springbootdemo.utils.excel.processor.TypeProcessor;
import java.text.ParseException;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-12-25 10:40
 */
public class StringProcessorImpl implements TypeProcessor {
    @Override
    public Object fromString(String preValue) throws ParseException {
        return preValue;
    }

    @Override
    public String toString(Object value) throws ParseException {
        if(value == null){
            return "";
        }
        return value.toString();
    }
}
