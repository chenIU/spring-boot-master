package com.ruida.springbootdemo.utils.excel.processor.impl;

import com.ruida.springbootdemo.utils.excel.processor.TypeProcessor;
import org.apache.commons.lang3.StringUtils;
import java.text.ParseException;
import java.util.Objects;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-12-25 14:51
 */
public class BooleanProcessorImpl implements TypeProcessor {
    @Override
    public Object fromString(String preValue) throws ParseException {
        if(StringUtils.isBlank(preValue)){
            return null;
        }

        if(Objects.equals("是",preValue) || Objects.equals("true",preValue)){
            return true;
        }else if(Objects.equals("否",preValue) || Objects.equals("false",preValue)){
            return false;
        }else {
            throw new ParseException(preValue + "无法转换为boolean类型",0);
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
