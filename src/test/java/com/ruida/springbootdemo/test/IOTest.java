package com.ruida.springbootdemo.test;

import org.apache.poi.util.IOUtils;
import org.junit.Test;

import java.io.*;
import java.util.Arrays;

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

    @Test
    public void byteArrayInputOutputTest(){

        //测试字节输入流
        byte[] buf = new byte[]{'a','b','c'};
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(buf);
        System.out.println("byteArrayInputStream长度:" + byteArrayInputStream.available());

        //read方法
        int len;
        while( (len=byteArrayInputStream.read()) != -1){
            System.out.printf("%s ",len);//97 98 99
        }

        System.out.println();

        //总结：输入流读出之后会从原输入流中删除其内容

        //read(byte b[],int off,int len)
        byteArrayInputStream = new ByteArrayInputStream(buf);
        System.out.println("byteArrayInputStream长度:" + byteArrayInputStream.available());
        byte[] b = new byte[buf.length];
        while(byteArrayInputStream.read(b,0,b.length) != -1){
            System.out.println(Arrays.toString(b));
        }

        //测试字节输出流
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(100);
        byte[] bytes = byteArrayOutputStream.toByteArray();
        String s = new String(bytes);
        System.out.println(s);
    }

    @Test
    public void readAndWriteExcel() throws Exception {
//        Workbook wb = new XSSFWorkbook();
//        wb.createSheet("测试一下");
//        wb.write();

        FileInputStream in = new FileInputStream("D://test.xlsx");
        FileOutputStream out = new FileOutputStream("D://test2.xlsx");
        IOUtils.copy(in,out);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.toByteArray();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
    }

    @Test
    public void testVideo(){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            long start = System.currentTimeMillis();
            fis = new FileInputStream("F:\\video\\灵笼-特别篇.flv");
            fos = new FileOutputStream("G://test.flv");
            byte[] buf = new byte[8 * 1024];
            int len;
            while((len = fis.read(buf)) != -1){
                fos.write(buf, 0, len);
            }
            fos.flush();
            System.out.println("耗时" + (System.currentTimeMillis() - start) + "ms");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
