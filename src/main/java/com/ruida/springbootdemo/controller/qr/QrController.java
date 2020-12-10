package com.ruida.springbootdemo.controller.qr;

import com.ruida.springbootdemo.utils.QRCodeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * @description: 二维码控制器
 * @author: chenjy
 * @create: 2020-12-10 14:55
 */
@Controller
@RequestMapping("/qrCode")
public class QrController {

    @RequestMapping()
    public String go(){
        return "qrCode";
    }

    @GetMapping("/generator")
    @ResponseBody
    public void encodeQrCode(String codeContent, HttpServletResponse response){
        String imgPath = "E:\\nil.jpeg";
        try {
            QRCodeUtil.encode(codeContent,imgPath,true,response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
