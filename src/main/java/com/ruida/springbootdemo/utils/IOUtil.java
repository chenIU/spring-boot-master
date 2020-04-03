package com.ruida.springbootdemo.utils;

import java.io.*;

/**
 * @description: IO工具类
 * @author: chenjy
 * @create: 2020-04-01 08:31
 */
public class IOUtil {

    public static void main(String[] args) {
        String source = "D:\\file\\from.txt";
        String dest = "D:\\file\\to.txt";
        //System.out.println(readFileMethod1(source));
        //System.out.println(readFileMethod2(source));
        //System.out.println(readFileMethod3(source));
        //readAndWriteMethod1(source,dest);
        //readAndWriteMethod2(source,dest);
        //readAndWriteMethod3(source,dest);
        //readAndWriteMethod4(source,dest);
        //readAndWriteMethod5(source,dest);
    }

    public static String readFileMethod1(String source){
        StringBuffer sb = new StringBuffer();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(source));
            String line;
            while((line=br.readLine())!=null){
                sb.append(line);
                sb.append("\n");
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static String readFileMethod2(String source){
        File file = new File(source);
        byte[] buffer = new byte[(int) file.length()];
        try {
            InputStream in = new FileInputStream(file);
            in.read(buffer);
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(buffer);
    }

    public static String readFileMethod3(String source){
        byte[] buffer = new byte[1024];
        try {
            InputStream in = new FileInputStream(new File(source));
            int i;
            int index=0;
            while((i=in.read())!=-1){
                buffer[index] = (byte) i;
                index++;
            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(buffer);
    }

    public static void readAndWriteMethod1(String source,String dest){
        byte[] buffer = new byte[1024];
        try {
            InputStream in = new FileInputStream(new File(source));
            OutputStream out = new FileOutputStream(new File(dest));
            int n;
            while((n=in.read(buffer,0,buffer.length))!=-1){
                out.write(buffer,0,n);
            }
            out.close();
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readAndWriteMethod2(String source,String dest){
        try {
            InputStream in = new BufferedInputStream(new FileInputStream(new File(source)));
            OutputStream out = new BufferedOutputStream(new FileOutputStream(new File(dest)));
            byte[] buffer = new byte[1024];
            int n;
            while((n=in.read(buffer,0,buffer.length))!=-1){
                out.write(buffer,0,n);
            }
            out.close();
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readAndWriteMethod3(String source,String dest){
        try {
            InputStreamReader in = new InputStreamReader(new FileInputStream(source));
            OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(dest));
            int len;
            while((len=in.read())!=-1){
                out.write(len);
            }
            out.close();
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readAndWriteMethod4(String source,String dest){
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(source)));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(dest)));
            String line;
            while((line=in.readLine())!=null){
                out.write(line);
                out.write("\n");
            }
            out.close();
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readAndWriteMethod5(String source,String dest){
        try {
            Reader in = new FileReader(source);
            Writer out = new FileWriter(dest);
            int index;
            while((index=in.read())!=-1){
                out.write(index);
            }
            out.close();
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
