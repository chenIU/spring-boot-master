package com.ruida.springbootdemo.utils.excel.processor.impl;

import com.ruida.springbootdemo.utils.excel.processor.TypeProcessor;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.text.ParseException;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-12-25 15:00
 */
public class BigDecimalProcessorImpl implements TypeProcessor {

    int scale;

    public BigDecimalProcessorImpl(int scale){
        this.scale = scale;
    }

    @Override
    public Object fromString(String preValue) throws ParseException {
        if(StringUtils.isBlank(preValue)){
            return BigDecimal.ZERO;
        }
        try {
            BigDecimal res = new BigDecimal(preValue);
            if(scale > -1){
                res.setScale(scale,BigDecimal.ROUND_HALF_UP);
            }
            return res;
        }catch (NumberFormatException ex){
            throw new ParseException(preValue + "无法转换为数字类型",0);
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
