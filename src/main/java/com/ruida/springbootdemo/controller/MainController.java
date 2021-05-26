package com.ruida.springbootdemo.controller;

import com.ruida.springbootdemo.entity.result.PojoResult;
import com.ruida.springbootdemo.enums.OrderStatusEnum;
import com.ruida.springbootdemo.utils.ExcelUtil;
import com.ruida.springbootdemo.utils.HttpRequestUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-10-29 13:39
 */
@RestController
@RequestMapping("/main/")
@Slf4j
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

    @GetMapping("downloadExcel")
    public void download(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //获取客户端的User-Agent
        String header = request.getHeader("User-Agent");
        Map<String, Object> body = HttpRequestUtil.getBody(request);
        String path = (String) body.get("path");
        log.info(path);

        String fileName = "测试.xlsx";

        //清除空白行
        response.reset();
        //设置附件情况
        //URLEncoder.encode 处理文件名中文乱码情况
        response.setHeader("Content-Disposition","attachment;filename=" + URLEncoder.encode(fileName,"UTF-8"));
        //设置Content-Type
        response.setContentType("application/octet-stream");

        FileInputStream fis = new FileInputStream("D://测试.xlsx");
        OutputStream out = response.getOutputStream();
        byte[] buf = new byte[8 * 1024];
        int len;
        while((len = fis.read(buf)) != -1){
            out.write(buf, 0, len);
        }
        out.flush();
        fis.close();
    }

    @GetMapping("downloadTemplate")
    public void downloadTemplate(HttpServletRequest request,HttpServletResponse response){
        try {
            ExcelUtil.downloadStaticFile(request,response,"工伤处理导入模板.xlsx");
        } catch (Exception e) {
            log.error("工伤处理导入模板下载失败");
        }
    }

    @GetMapping({"/","/index"})
    public String index(){
        return "index";
    }
}
