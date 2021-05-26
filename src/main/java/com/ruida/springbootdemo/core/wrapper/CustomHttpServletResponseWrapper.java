package com.ruida.springbootdemo.core.wrapper;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/**
 * @author：chenjianyin
 * @date：2020/6/19 15:49
 * @desc：
 */
public class CustomHttpServletResponseWrapper extends HttpServletResponseWrapper {

    private HttpServletResponse response;

    public static final String charset = "UTF-8";

    public CustomHttpServletResponseWrapper(HttpServletResponse response) {
        super(response);
        /*this.response.setCharacterEncoding(charset);
        this.response = response;*/
    }

}
