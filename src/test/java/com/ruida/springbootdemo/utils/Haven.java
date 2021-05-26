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
public class Haven {

    public static void downloadTopList(String url, int pageSize, String divId, String folderName) {
        String prefix = "F:\\Internet";
        File dest = new File(prefix + "\\" + folderName);
        if (!dest.exists()) {
            dest.mkdirs();
        }
        try {
            long start = System.currentTimeMillis();
            int id = 0;
            for (int i = 1; i <= pageSize; i++) {
                url = url + i;
                Document document = Jsoup.parse(new URL(url), 30000);
                Element element = document.getElementById(divId);
                Elements images = element.getElementsByClass("jsAnchor thumb-tags-toggle tagged");
                for (Element img : images) {
                    String src = img.attr("data-href");
                    Document dom = Jsoup.parse(new URL(src), 30000);
                    Element wallpaper = dom.getElementById("wallpaper");
                    String path = wallpaper.attr("src");
                    URL target = new URL(path);
                    URLConnection urlConnection = target.openConnection();
                    urlConnection.setConnectTimeout(30000);
                    urlConnection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt");
                    InputStream inputStream = urlConnection.getInputStream();
                    id++;
                    OutputStream outputStream = new BufferedOutputStream(new FileOutputStream("F:\\Internet\\" + folderName + "\\" + id + ".jpg"));
                    int tmp;
                    while ((tmp = inputStream.read()) != -1) {
                        outputStream.write(tmp);
                    }
                    System.out.println(id + ".jpg写入成功!");
                    outputStream.close();
                    inputStream.close();
                }
            }
            long end = System.currentTimeMillis();
            System.out.println("所有图片写入完毕!共耗时" + (end - start) / 1000 + "s");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        downloadTopList("https://wallhaven.cc/toplist?page=", 3, "thumbs", "haven4");
    }
}
