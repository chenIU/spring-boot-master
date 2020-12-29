package com.ruida.springbootdemo.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-11-24 10:09
 */
public class Test4 {
    public static void main(String[] args) throws IOException {
        String str = "松下问童子，言师采药去。只在此山中，云深不知处。";
        FileWriter fw = new FileWriter("E:/test.txt");
        fw.write(str);
        fw.close();

        FileReader fr = new FileReader("E:/test.txt");
        char[] chars = new char[1024];
        StringBuilder sb = new StringBuilder();
        int len;
        while ((len = fr.read(chars)) != -1){
            sb.append(chars,0,len);
        }
        fr.close();
        System.out.println(sb.toString());
    }
}
