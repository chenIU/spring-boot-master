package com.ruida.springbootdemo.filter;

import com.ruida.springbootdemo.core.wrapper.CustomHttpServletRequestWrapper;
import com.ruida.springbootdemo.core.wrapper.CustomHttpServletResponseWrapper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author：chenjianyin
 * @date：2020/6/19 15:55
 * @desc：全局请求过滤器
 */
public class GlobalRequestFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        CustomHttpServletRequestWrapper requestWrapper = new CustomHttpServletRequestWrapper(request);
        CustomHttpServletResponseWrapper responseWrapper = new CustomHttpServletResponseWrapper(response);
        filterChain.doFilter(requestWrapper,responseWrapper);
    }

    @Override
    public void destroy() {

    }

}
