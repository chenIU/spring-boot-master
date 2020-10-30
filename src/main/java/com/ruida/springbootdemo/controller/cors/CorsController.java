package com.ruida.springbootdemo.controller.cors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * CrossOrigin可以加在类和方法上
 * @author chenjy
 * @since 2020/10/27 21:16
 */
@RestController
@RequestMapping("/cors/")
//@CrossOrigin(origins = "http://localhost:8081")
public class CorsController {

    @GetMapping("getData")
    //@CrossOrigin(origins = "http://localhost:8081")
    public String getData(){
        return "cors getData!";
    }

    @PutMapping("putData")
    public String putData(){
        return "cors putData!";
    }
}
