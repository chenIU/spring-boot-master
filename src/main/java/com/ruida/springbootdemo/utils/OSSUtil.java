package com.ruida.springbootdemo.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.OSSObjectSummary;
import com.aliyun.oss.model.ObjectListing;
import com.aliyun.oss.model.PutObjectRequest;

import java.io.*;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-12-17 12:00
 */
public class OSSUtil {

    private static String endpoint = "http://oss-cn-hangzhou.aliyuncs.com";

    private static String accessKeyId = "xxx";

    private static String accessKeySecret = "bbb";

    private static final String bucketName = "chenjy";

    /**
     * 创建bucket
     * @param bucketName
     */
    public static void createBucket(String bucketName) {

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        // 创建存储空间。
        ossClient.createBucket(bucketName);

        // 关闭OSSClient。
        ossClient.shutdown();
    }

    /**
     * 上传文件
     * @param bucketName
     * @param objectName
     */
    public static void upload(String bucketName,String objectName) throws IOException {
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        // 上传文件到指定的存储空间（bucketName）并将其保存为指定的文件名称（objectName）。
        ossClient.putObject(new PutObjectRequest(bucketName, objectName, createSampleFile()));

        // 关闭OSSClient。
        ossClient.shutdown();
    }

    /**
     * 下载文件
     * @param bucketName
     * @param objectName
     * @return
     */
    public static InputStream download(String bucketName,String objectName){
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        // 调用ossClient.getObject返回一个OSSObject实例，该实例包含文件内容及文件元信息。
        OSSObject ossObject = ossClient.getObject(bucketName, objectName);

        // 调用ossObject.getObjectContent获取文件输入流，可读取此输入流获取其内容。
        InputStream content = ossObject.getObjectContent();

        // 关闭OSSClient。
        ossClient.shutdown();
        return content;
    }

    /**
     * 列出bucket中的对象
     * @param bucketName
     */
    public static void listObjects(String bucketName){
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        // ossClient.listObjects返回ObjectListing实例，包含此次listObject请求的返回结果。
        ObjectListing objectListing = ossClient.listObjects(bucketName);

        // objectListing.getObjectSummaries获取所有文件的描述信息。
        for (OSSObjectSummary objectSummary : objectListing.getObjectSummaries()) {
            System.out.println(" - " + objectSummary.getKey() + "  " +
                    "(size = " + objectSummary.getSize() + ")");
        }

        // 关闭OSSClient。
        ossClient.shutdown();
    }

    /**
     * 删除对象
     * @param bucketName
     * @param objectName
     */
    public static void deleteObject(String bucketName,String objectName){
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        // 删除文件。
        ossClient.deleteObject(bucketName, objectName);

        // 关闭OSSClient。
        ossClient.shutdown();
    }

    private static File createSampleFile() throws IOException {
        File file = File.createTempFile("oss-java-sdk-", ".txt");
        file.deleteOnExit();

        Writer writer = new OutputStreamWriter(new FileOutputStream(file));
        writer.write("abcdefghijklmnopqrstuvwxyz\n");
        writer.write("0123456789011234567890\n");
        writer.close();

        return file;
    }



    public static void main(String[] args) throws IOException {
//        createBucket(bucketName);
        upload(bucketName,"test");
//        InputStream in = download(bucketName,"demo/nil.jpeg");
//        try {
//            System.out.println(in.available());
//            byte[] buffer = new byte[in.available()];
//            File file = new File("E:\\oss");
//            if(!file.exists()){
//                file.mkdirs();
//            }
//            FileOutputStream fis = new FileOutputStream(file);
//            int len;
//            while((len = in.read(buffer)) != -1){
//                fis.write(buffer,0,len);
//            }
//            in.close();
//            fis.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        listObjects(bucketName);
//        deleteObject(bucketName,"demo/nil.jpeg");
    }
}
