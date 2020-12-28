package com.ruida.springbootdemo.utils.excel.processor;

import com.ruida.springbootdemo.utils.excel.processor.impl.*;

import java.util.Objects;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-12-25 10:42
 */
public class TypeProcessorFactory {

    private TypeProcessorFactory(){

    }

    public static class Singleton{
        public static TypeProcessorFactory instance = new TypeProcessorFactory();
    }

    public static TypeProcessorFactory getInstance(){
        return Singleton.instance;
    }

    public TypeProcessor getProcessor(String paramString,int scale,String dateFormat){
        if(Objects.equals("class java.lang.String",paramString)){
            return new StringProcessorImpl();
        }else if(Objects.equals("class java.lang.Boolean",paramString)){
            return new BooleanProcessorImpl();
        }else if(Objects.equals("class java.util.Date",paramString)){
            return new DateProcessorImpl(dateFormat);
        }else if(Objects.equals("class java.lang.Integer",paramString)){
            return new IntegerProcessorImpl();
        }else if(Objects.equals("class java.lang.Long",paramString)){
            return new LongProcessorImpl();
        }else if(Objects.equals("class java.math.BigDecimal",paramString)){
            return new BigDecimalProcessorImpl(scale);
        }
        return null;
    }
}
