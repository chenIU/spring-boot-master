package com.ruida.springbootdemo.io;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-11-25 10:38
 */
public class Test6 {

    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("E:/test.txt");
        StringBuilder sb = new StringBuilder();
        String str = "s";
        for(int i = 0;i< 65535;i++){
            sb.append(str);
        }
        System.out.println(sb.toString());
        fw.write(sb.toString());
        fw.close();
    }
}
