package com.ruida.springbootdemo.controller;

import com.ruida.springbootdemo.entity.result.PojoResult;
import com.ruida.springbootdemo.enums.OrderStatusEnum;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-10-29 13:39
 */
@RestController
public class MainController {

    @Value("${server.port}")
    private Integer port;

    @RequestMapping(value = "set",method = RequestMethod.GET)
    public String set(HttpSession session){
        session.setAttribute("user","chenjy");
        return String.valueOf(port);
    }

    @RequestMapping(value = "get",method = RequestMethod.GET)
    public String get(HttpSession session){
        return session.getAttribute("user") + ":" + port;
    }

    @GetMapping("queryOrderStatus")
    public PojoResult queryOrderStatus(){
        PojoResult<Object> result = new PojoResult<>();
        result.setContent(OrderStatusEnum.values());
        return result;
    }

    /**
     * 设置cookie
     * @param response
     * @return
     */
    @GetMapping("setCookie")
    public String setCookie(HttpServletResponse response){
        Cookie cookie = new Cookie("username", "jack");
        cookie.setMaxAge(7 * 24 * 60 * 60);
        response.addCookie(cookie);
        return "cookie is set!";
    }

    /**
     * 使用Spring框架提供的@CookieValue注解获取特定的 cookie的值
     * @param username
     * @return
     */
    @GetMapping("readCookie")
    public String readCookie(@CookieValue(value = "username", defaultValue = "Amy") String username) {
        return "Hey! My username is " + username;
    }

    /**
     * 获取所有cookie值
     * @param request
     * @return
     */
    @GetMapping("readAllCookies")
    public String readAllCookie(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            return Arrays.stream(cookies).map(c -> c.getName() + "=" + c.getValue()).collect(Collectors.joining(", "));
        }
        return "No Cookies!";
    }
}
