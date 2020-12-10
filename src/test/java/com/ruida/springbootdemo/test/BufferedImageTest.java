package com.ruida.springbootdemo.test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-12-10 15:56
 */
public class BufferedImageTest {
    public static void main(String[] args) throws IOException {
        BufferedImage image = ImageIO.read(new FileInputStream("E://nil.jpeg"));
        System.out.println(image.getWidth());
        System.out.println(image.getHeight());
        image.getSubimage(10,50,100,200);

        BufferedImage out = new BufferedImage(300,300,BufferedImage.TYPE_INT_RGB);
        Graphics g = out.getGraphics();
        //画直线
        g.drawLine(3,3,50,50);

        //画点
        g.drawLine(100,100,100,100);

        //画字符串
        g.drawString("hello",200,20);

        //使用FontMetrics精确定位
        String s1 = "Hello, Java World!";
        g.setColor(Color.red);
//        setBackground(new Color(0,255,0));
        Font font = new Font("Arial", Font.BOLD, 18);
        g.setFont(font);
        FontMetrics fm = g.getFontMetrics(font);
        int height = fm.getHeight();
        int width = fm.stringWidth(s1);
        int posx =50;
        int posy = 50;
        g.drawString(s1 ,posx, posy);
        g.drawString("I will come in." ,posx +width, posy+height);
        ImageIO.write(out,"png",new FileOutputStream("E:\\test.png"));
    }
}
