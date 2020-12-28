package com.ruida.springbootdemo.controller;

import com.ruida.springbootdemo.constant.SystemConstant;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.util.CollectionUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 基础控制器
 * @author: chenjy
 * @create: 2020-04-29 13:04
 */
public abstract class BaseController {

    public BaseController() {
//        request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
    }

    protected HttpServletRequest getRequest(){
        return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
    }

    protected HttpServletResponse getResponse(){
        return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getResponse();
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

    protected void download(HttpServletResponse response, Workbook workbook,String fileName) throws Exception {
        //防止中文乱码
        fileName = URLEncoder.encode(fileName, SystemConstant.UTF8);

        response.setContentType(SystemConstant.DOWNLOAD_PROTOCOL);
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        OutputStream os = response.getOutputStream();
        workbook.write(os);
        os.flush();
        os.close();
    }

    protected void download(HttpServletResponse response, InputStream in,String fileName){
        try {
            fileName = URLEncoder.encode(fileName,SystemConstant.UTF8);

            response.reset();
            response.setHeader("Content-disposition", "attachment;filename=" + fileName);
//            response.setContentType("application/octet-stream");
            //application/octet-stream是默认的未知类型
            response.setContentType(SystemConstant.DOWNLOAD_PROTOCOL);

            byte[] buf = new byte[in.available()];
            int len;
            OutputStream out = response.getOutputStream();
            while((len =in.read(buf)) != -1){
                out.write(buf,0,len);
            }

            out.flush();
            out.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
