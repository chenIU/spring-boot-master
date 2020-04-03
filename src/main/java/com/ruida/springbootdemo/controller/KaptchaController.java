package com.ruida.springbootdemo.controller;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 二维码生成控制器
 * @author: chenjy
 * @create: 2020-04-01 16:02
 */
@RestController
@RequestMapping("/kaptcha")
@Slf4j
public class KaptchaController {

    @Resource
    private DefaultKaptcha producer;

    @RequestMapping("")
    public Map<String,Object> kapcha() throws IOException {
        Map<String,Object> map = new HashMap();
        log.info("开始生成二维码...");
        String text = producer.createText();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        BufferedImage image = producer.createImage(text);
        ImageIO.write(image,"jpg",out);
        map.put("errorCode","000000");
        map.put("errorMsg","请求成功!");
        map.put("img", "data:image/jpg;base64,"+Base64.encodeBase64String(out.toByteArray()));
        log.info("生成二维码完成...");
        return map;
    }
}
