package com.ruida.springbootdemo.io;

import java.io.*;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-11-24 10:01
 */
public class Test3 {
    public static void main(String[] args) throws IOException {
        String str = "松下问童子，言师采药去。只在此山中，云深不知处。";
        OutputStreamWriter osr = new OutputStreamWriter(new FileOutputStream(new File("E:/test.txt")));

        osr.write(str);
        osr.close();

        InputStreamReader isr = new InputStreamReader(new FileInputStream(new File("E:/test.txt")));
        char[] chars = new char[1024];
        StringBuilder sb = new StringBuilder();
        int len;
        while((len = isr.read(chars)) != -1){
            sb.append(chars,0,len);
        }
        isr.close();
        System.out.println(sb.toString());
    }
}
