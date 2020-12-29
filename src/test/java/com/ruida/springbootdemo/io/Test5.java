package com.ruida.springbootdemo.io;

import java.io.*;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-11-24 10:14
 */
public class Test5 {
    public static void main(String[] args) throws IOException {
        String str = "松下问童子，言师采药去。只在此山中，云深不知处。";
        BufferedWriter bw = new BufferedWriter(new FileWriter("E:/test.txt"));
        bw.write(str);
        bw.close();

        BufferedReader br = new BufferedReader(new FileReader("E:/test.txt"));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null){
            sb.append(line);
        }
        br.close();
        System.out.println(sb.toString());
    }
}
