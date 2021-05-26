package com.ruida.springbootdemo.test;


import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.*;

/**
 * @author Chen.J.Y
 * @date 2021/5/25
 * @desc common-io
 */
public class IOUtilsTest {

    @Test
    public void read() {
        try {
            FileInputStream fis = new FileInputStream("D://test.txt");
            System.out.println(IOUtils.toString(fis));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void write() {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            IOUtils.write("222", bos);
            System.out.println(bos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void copy() {
        try {
            FileInputStream fis = new FileInputStream("D://test.xlsx");
            FileOutputStream fos = new FileOutputStream("D://test2.xlsx");
            try {
                IOUtils.copy(fis, fos);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void close() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("D://test.txt");
            fos = new FileOutputStream("D://test2.txt");
            byte[] buf = new byte[8 * 1024];
            int len;
            while ((len = fis.read(buf)) != -1) {
                fos.write(buf, 0, len);
            }
            fos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(fis);
            IOUtils.closeQuietly(fos);
        }
    }
}
