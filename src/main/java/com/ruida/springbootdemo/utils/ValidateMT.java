package com.ruida.springbootdemo.utils;

import java.util.Collection;
import java.util.Map;

/**
 * @description: 校验对象是否为空
 * @author: chenjy
 * @create: 2020-12-18 14:11
 */
public class ValidateMT {

    public static boolean isNotNull(Object obj){
        if(obj instanceof String){
            if(obj == null || ((String) obj).length() == 0){
                return false;
            }
            return true;
        }else if(obj instanceof Collection<?>){
            if(obj == null || ((Collection) obj).size() == 0){
                return false;
            }
            return true;
        }else if(obj instanceof Map<?,?>){
            if(obj == null || ((Map) obj).isEmpty()){
                return false;
            }
            return true;
        }else {
            return obj == null;
        }
    }

    public static boolean isNull(Object obj){
        return !isNotNull(obj);
    }
}
