package com.ruida.springbootdemo.file;

import java.io.File;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-11-24 11:20
 */
public class FileTest1 {
    public static void main(String[] args) {
        File file = new File("E:/test");
        System.out.println(file.delete());
    }
}
