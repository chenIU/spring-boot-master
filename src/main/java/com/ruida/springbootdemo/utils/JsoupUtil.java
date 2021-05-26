package com.ruida.springbootdemo.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author chenjy
 * @since 2021/1/24 15:47
 */
public class JsoupUtil {

    public static void downloadInternetImages(String url,String divId,String folderName){
        String prefix = "F:\\Internet";
        File dest = new File(prefix + "\\" + folderName);
        if(!dest.exists()){
            dest.mkdirs();
        }
        try {
            Document document = Jsoup.parse(new URL(url), 30000);
            Element element = document.getElementById(divId);
            Elements images = element.getElementsByTag("img");
            int id = 0;
            long start = System.currentTimeMillis();
            for(Element img : images){
                String src = img.attr("src");
                URL target = new URL(src);
                URLConnection urlConnection = target.openConnection();
                urlConnection.setConnectTimeout(60000);
                InputStream inputStream = urlConnection.getInputStream();
                id ++;
                OutputStream outputStream = new BufferedOutputStream(new FileOutputStream("F:\\Internet\\" + folderName + "\\" + id + ".jpg"));
                int tmp;
                while ((tmp = inputStream.read()) != -1){
                    outputStream.write(tmp);
                }
                System.out.println(id + ".jpg写入成功!");
                outputStream.close();
                inputStream.close();
            }
            long end = System.currentTimeMillis();
            System.out.println("所有图片写入完毕!共耗时" + (end - start) / 1000 + "s");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        downloadInternetImages("http://www.ruanyifeng.com/blog/2021/01/weekly-issue-142.html","main-content","ryf");
    }
}
