package com.ruida.springbootdemo.utils.excel.processor;

import java.text.ParseException;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-12-25 10:29
 */
public interface TypeProcessor {

    Object fromString(String preValue) throws ParseException;

    String toString(Object value) throws ParseException;

}
