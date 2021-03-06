package com.ruida.springbootdemo.test;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * @author chenjy
 * @date 2021/3/6
 */
public class TestThumbnailator {

    private final String file = "G:\\test.png";

    private final String dest = "G:\\copy.png";

    private final String watermark = "G:\\watermark.png";

    /**
     * 改变文件大小
     * @throws IOException
     */
    @Test
    public void changeSize() throws IOException {
        Thumbnails.of(file).size(200,300).toFile(dest);
    }

    /**
     * 缩放图片
     * @throws IOException
     */
    @Test
    public void changeScale() throws IOException {
        Thumbnails.of(file).scale(0.5).toFile(dest);
    }

    /**
     * 旋转图片
     * 必须要调scale方法
     * @throws IOException
     */
    @Test
    public void rotate() throws IOException {
        Thumbnails.of(file).scale(1).rotate(180).toFile(dest);
    }

    /**
     * 裁剪图片
     * 必须要调scale方法
     * @throws IOException
     */
    @Test
    public void region() throws IOException {
        Thumbnails.of(file).scale(1).sourceRegion(Positions.CENTER,300,300).toFile(dest);
    }

    /**
     * 图片添加水印
     * 必须要调scale方法
     * @throws IOException
     */
    @Test
    public void setWatermark() throws IOException {
        Thumbnails.of(file).scale(1).watermark(Positions.BOTTOM_RIGHT,ImageIO.read(new File(watermark)),0.5f).toFile(dest);
    }

}
