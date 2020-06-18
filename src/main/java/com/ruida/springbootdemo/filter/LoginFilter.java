package com.ruida.springbootdemo.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import java.io.IOException;

/**
 * @description: 登录过滤器
 * @author: chenjy
 * @create: 2020-06-18 15:02
 */
@Slf4j
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.warn("LoginFilter initializing");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        log.info("LoginFilter is running...");
        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }

}
