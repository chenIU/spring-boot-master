package com.ruida.springbootdemo.test;

import java.io.File;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-11-02 13:31
 */
public class IOTest {
    public static void main(String[] args) {
        String path = "E:\\file\\test";
        File file = new File(path);
        if(!file.exists()){
            //file.mkdir();

            file.mkdirs();
        }
    }
}
