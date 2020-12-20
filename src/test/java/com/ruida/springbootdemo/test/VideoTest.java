package com.ruida.springbootdemo.test;

import java.io.File;
import java.util.Arrays;

/**
 * @author chenjy
 * @since 2020/11/29 20:05
 */
public class VideoTest {
    public static void main(String[] args) {
        File src = new File("G:/111");
        String format = ".mp4";
        String dest = "G:/222/";
        for (File f: Arrays.asList(src.listFiles())){
            f.renameTo(new File(dest  + f.getName().substring(0,f.getName().lastIndexOf(".")) + format));
        }
    }
}
