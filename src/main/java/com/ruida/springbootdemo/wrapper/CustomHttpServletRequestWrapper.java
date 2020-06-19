package com.ruida.springbootdemo.wrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * @author：chenjianyin
 * @date：2020/6/19 16:06
 * @desc：
 */
public class CustomHttpServletRequestWrapper extends HttpServletRequestWrapper {

    private HttpServletRequest request;

    public CustomHttpServletRequestWrapper(HttpServletRequest request) {
        super(request);
        this.request = request;
    }

    @Override
    public String getParameter(String name) {
        return "request wrapper："+request.getParameter(name);
    }

}
