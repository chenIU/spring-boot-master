package com.ruida.springbootdemo.controller;

import com.alibaba.fastjson.JSONObject;
import com.ruida.springbootdemo.config.DataSource;
import com.ruida.springbootdemo.entity.Student;
import com.ruida.springbootdemo.exception.BizException;
import com.ruida.springbootdemo.service.ISinger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 用户请求控制器
 * @author: chenjy
 * @create: 2020-03-27 11:13
 */
@RestController()
@RequestMapping("/user/")
@Slf4j
public class UserController {

    private static final ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    public static final String CHARSET = "UTF-8";

    @Value("${server.port}")
    private Integer port;

    @Autowired
    @Qualifier("operaSinger")
    ISinger singer;

    @Autowired
    private DataSource dataSource;

    @RequestMapping("test")
    public String test() {
        singer.sing();
        return "hello world from " + port;
    }

    @GetMapping("use")
    public void useThrealLocal(Integer integer, HttpServletRequest request) throws InterruptedException {
        threadLocal.set(integer);
        log.info("修改threadLocal成员变量" + integer);
        Thread.sleep(5000);
        log.info("输出成员变量" + threadLocal.get());
    }

    @RequestMapping(value = "wechat", method = RequestMethod.GET)
    public void wechat(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=" + CHARSET);
        response.getWriter().write("中国");
        response.getWriter().flush();
        response.getWriter().close();
    }

    @RequestMapping(value = "request")
    public void request(HttpServletRequest request, HttpServletResponse response) {
        try {
            InputStream in = request.getInputStream();
            byte b[] = new byte[1024];
            int len = 0;
            int tmp;
            while ((tmp = in.read()) != -1) {
                b[len] = (byte) tmp;
                len++;
            }
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().write(new String(b));
            response.getWriter().flush();
            response.getWriter().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("auth")
    public void auth(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(request.getServletPath());
        System.out.println(request.getRequestURL());
        System.out.println(request.getHeader("auth"));
        response.setContentType("text/html;charset=UTF-8");
    }

    @RequestMapping("login")
    public Map<String, Object> login() {
        Map<String, Object> map = new HashMap();
        map.put("errorCode", 200);
        map.put("errorMsg", "登录成功");
        return map;
    }

    @RequestMapping(value = "updateUserInfo", method = RequestMethod.PUT)
    public Map<String, Object> updateUserInfo(@RequestParam(name = "userName", required = false) String userName,
                                              @RequestParam(name = "password", required = false) String password) {
        Map<String, Object> map = new HashMap();
        map.put("errorCode", 200);
        map.put("errorMsg", "修改成功");
        return map;
    }

    @RequestMapping("exception")
    public JSONObject exception() {
        throw new BizException("E_100500", "手机号码绑定失败", 500);
    }

    @RequestMapping("getStudentInfo")
    public Student getStudentInfo(){
        Student stu = null;
        int i = 1/0;
        if(null==stu){
            throw new BizException("E10001","实体对象为空",401);
        }else {
            return stu;
        }
    }

}
