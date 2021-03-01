package com.ruida.springbootdemo.utils;

import java.io.*;

/**
 * @description: IO工具类
 * @author: chenjy
 * @create: 2020-04-01 08:31
 */
public class IOUtil {

    public static void main(String[] args) {
        String source = "G:\\test.txt";
        String dest = "D:\\IO\\to.txt";
        String objDest = "D:\\IO\\obj.txt";
        String path = "D:\\apache-maven-3.6.3";
        //Student student = new Student("chenjy",26);
        //System.out.println(readFileMethod1(source));
        //System.out.println(readFileMethod2(source));
        System.out.println(readFileMethod3(source));
        //readAndWriteMethod1(source,dest);
        //readAndWriteMethod2(source,dest);
        //readAndWriteMethod3(source,dest);
        //readAndWriteMethod4(source,dest);
        //readAndWriteMethod5(source,dest);
        //writeObject(student,objDest);
        //readOjbect(objDest);
        //listFile(path);
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

    /**
     * 这种方法读取数据，有时会出现截取而造成乱码的情况，byte[]数组的大小和文件大小有密切关系
     * 原因：UTF8编码中，一个汉字占用三个字节
     * 读取文本推荐使用BufferedReader.readLine()
     * @param source
     * @return
     */
    public static String readFileMethod3(String source){
        byte[] buff = new byte[29];
        try {
            InputStream in = new FileInputStream(source);
            int i;
            while((i = in.read(buff)) != -1){
                System.out.println(new String(buff, 0, i));
            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
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

    public static void writeObject(Object obj,String dest){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(dest)));
            oos.writeObject(obj);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readOjbect(String source){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(source)));
            Object obj = ois.readObject();
            System.out.println(obj);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void listFile(String path){
        File file = new File(path);
        File[] files = file.listFiles();
        for (File f:files){
            if(f.isDirectory()){
                listFile(f.getPath());
            }
            System.out.println(f);
        }
    }

}
