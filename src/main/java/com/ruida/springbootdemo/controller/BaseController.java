package com.ruida.springbootdemo.controller;

import org.springframework.util.CollectionUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 基础控制器
 * @author: chenjy
 * @create: 2020-04-29 13:04
 */
public class BaseController {


    protected HttpServletRequest getRequest(){
        return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
    }

    protected Map<String,Object> convertParam(){

        HttpServletRequest request = getRequest();
        Map<String,Object> params = new HashMap();
        //表单参数
        Map<String,String[]> map = request.getParameterMap();

        if(!CollectionUtils.isEmpty(map)){
            for(Map.Entry<String, String[]> e:map.entrySet()){
                if(e.getValue() == null){
                    continue;
                }
                String value = "";
                if(e.getValue().length == 0){

                }else if(e.getValue().length == 1){
                    value = request.getParameter(e.getKey());
                }else {
                    String _t = Arrays.deepToString(e.getValue());
                    value = _t.substring(1,_t.length()-1);
                }
                params.put(e.getKey(),value);
            }
        }
        return params;
    }

}
