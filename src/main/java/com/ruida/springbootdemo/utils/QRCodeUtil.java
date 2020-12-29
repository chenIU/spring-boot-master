package com.ruida.springbootdemo.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-12-10 14:58
 */
@Slf4j
public class QRCodeUtil {
    
    private static final String CHARSET = "utf-8";

    //二维码尺寸
    private static final int QRCODE_SIZE = 300;

    //LOGO宽度
    private static final int WIDTH = 100;

    //LOGO高度
    private static final int HEIGHT = 100;

    //将前端传入的信息，编码成二维码
    public static void encode(String content, String imgPath, boolean compress, OutputStream out) throws Exception {
        BufferedImage image = createImage(content,imgPath,compress);
        ImageIO.write(image,"jpg",out);
    }

    //生成二维码核心代码
    private static BufferedImage createImage(String content,String imgPath,boolean compress) throws Exception {

        Map hints = new HashMap<>();
        //指定要使用的纠错程度，例如在二维码中
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        //指定字符编码
        hints.put(EncodeHintType.CHARACTER_SET,CHARSET);
        //指定生成二维码的边框（单位：像素）
        hints.put(EncodeHintType.MARGIN,1);

        //生成一个二维码位矩阵
        BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, QRCODE_SIZE, QRCODE_SIZE, hints);
        int width = bitMatrix.getWidth();
        int height = bitMatrix.getHeight();
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0 ; y < height; y++){
                //true是黑色，false是白色
                image.setRGB(x,y,bitMatrix.get(x,y) ? 0xFF000000 : 0xFFFFFFFF);
            }
        }

        if(StringUtils.isEmpty(imgPath)){
            return image;
        }

        //插入LOGO图片
        addLogo(image,imgPath,compress);
        return image;
    }

    /**
     * 插入LOGO
     * @param source
     * @param imgPath
     * @param compress
     * @throws IOException
     */
    private static void addLogo(BufferedImage source,String imgPath,boolean compress) throws IOException {
        File file = new File(imgPath);
        if(!file.exists()){
            log.error("文件不存在");
            return;
        }
        Image logo = ImageIO.read(file);
        int width = ((BufferedImage) logo).getWidth();
        int height = ((BufferedImage) logo).getHeight();

        //压缩LOGO
        if(compress){
            if(width > WIDTH){
                width = WIDTH;
            }
            if(height > HEIGHT){
                height = HEIGHT;
            }

            //创建此图像的缩放版本
            Image image = logo.getScaledInstance(width,height,Image.SCALE_SMOOTH);
            BufferedImage tag = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
            Graphics graphics = tag.getGraphics();

            //绘制缩小后的图
            graphics.drawImage(image,0,0,null);
            graphics.dispose();
            logo = image;
        }

        //插入LOGO
        Graphics2D graph = source.createGraphics();
        int x = (QRCODE_SIZE - width) / 2;
        int y = (QRCODE_SIZE - height) / 2;
        graph.drawImage(logo, x, y, width, height, null);
        Shape shape = new RoundRectangle2D.Float(x, y, width, width, 6, 6);
        graph.setStroke(new BasicStroke(3f));
        graph.draw(shape);
        graph.dispose();
    }
}
