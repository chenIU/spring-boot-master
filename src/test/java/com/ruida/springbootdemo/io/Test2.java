package com.ruida.springbootdemo.io;

import java.io.*;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-11-24 09:52
 */
public class Test2 {
    public static void main(String[] args) throws IOException {
        String str = "松下问童子，言师采药去。只在此山中，云深不知处。";
        OutputStream out = new BufferedOutputStream(new FileOutputStream(new File("E:/test.txt")));
        out.write(str.getBytes());
        out.flush();

        InputStream in = new BufferedInputStream(new FileInputStream(new File("E:/test.txt")));
        StringBuffer sb = new StringBuffer();
        byte[] buffer = new byte[1024];
        int len;
        while ((len = in.read(buffer)) != -1) {
            sb.append(new String(buffer, 0, len));
        }
        out.close();
        in.close();
        System.out.println(sb.toString());
    }
}
