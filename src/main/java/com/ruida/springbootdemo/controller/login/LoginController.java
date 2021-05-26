package com.ruida.springbootdemo.controller.login;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.ruida.springbootdemo.entity.result.CommonResult;
import com.ruida.springbootdemo.controller.BaseController;
import com.ruida.springbootdemo.enums.ErrorEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 登录控制器
 * @author: chenjy
 * @create: 2020-04-28 09:23
 */
@RestController
@RequestMapping("/login/")
@Slf4j
public class LoginController extends BaseController {

    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    @Resource
    private DefaultKaptcha producer;

    @RequestMapping(value = "test",method = RequestMethod.GET)
    public String test(){
        return "test";
    }

    @RequestMapping(value = "kaptcha",method = RequestMethod.GET)
    public Map<String,Object> kapcha() throws IOException {
        Map<String,Object> map = new HashMap();
        log.info("开始生成二维码...");
        String text = producer.createText();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        BufferedImage image = producer.createImage(text);
        ImageIO.write(image,"jpg",out);
        map.put("errorCode","000000");
        map.put("errorMsg","请求成功!");
        map.put("img", "data:image/jpg;base64,"+ Base64.encodeBase64String(out.toByteArray()));
        log.info("生成二维码完成...");
        return map;
    }

    @RequestMapping(value = "base",method = RequestMethod.GET)
    public String base(){
        Map<String,Object> map = this.convertParam();
        String username = (String) map.get("username");
        String password = (String) map.get("password");
        log.info("username=="+username+",password=="+password);
        return "we are testing base controller...";
    }

    /**
     * 登录
     * @param username 用户名
     * @param password 密码
     * @return
     */
    @PostMapping("loginByUsername")
    public CommonResult login(@RequestParam(value = "username",required = false)String username,
                              @RequestParam(value = "password",required = false) String password){
        //redisTemplate.opsForValue().set(String.format(SystemConstant.LOGIN_KEY,username),password);
        log.error(username);
        log.error(password);
        return CommonResult.build(ErrorEnum.OK);
    }

    @RequestMapping(value = "sensitive",method = RequestMethod.GET)
    public void sensitive(HttpServletRequest request, HttpServletResponse response){
        log.warn("login controller is running......");
        String username = request.getParameter("username");
        log.error(username);
    }

    @RequestMapping(value = "wrapper",method = RequestMethod.GET)
    public void wrapper(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        log.info(username);
    }

}
