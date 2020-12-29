package com.ruida.springbootdemo.utils.excel.processor.impl;

import com.ruida.springbootdemo.constant.SystemConstant;
import com.ruida.springbootdemo.utils.excel.processor.TypeProcessor;
import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-12-25 14:55
 */
public class DateProcessorImpl implements TypeProcessor {

    SimpleDateFormat sdf;

    public DateProcessorImpl(String dateFormat){
        if(dateFormat == null){
            dateFormat = SystemConstant.DATE_FORMAT;
        }
        sdf = new SimpleDateFormat(dateFormat);
    }

    @Override
    public Object fromString(String preValue) throws ParseException {
        if(StringUtils.isBlank(preValue)){
            return null;
        }
        if(preValue.endsWith(".0")){
            preValue = preValue.replace(".0","");
        }
        try {
            return sdf.parse(preValue);
        }catch (Exception e){
            throw new ParseException(preValue + "无法转换为日期类型",0);
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
