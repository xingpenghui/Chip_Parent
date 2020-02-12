package com.laoxing.chip.util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: Chip_Parent
 * @description: 实现二维码的操作
 * @author: Feri
 * @create: 2020-02-12 11:16
 */
public class QRcodeUtil {

    /**
     * @param msg 二维码的内容
     * @param width 二维码的大小*/
    public static BitMatrix createQrcode(String msg, int width){
        //创建缓存图片对象
        BufferedImage bufImg=null;
        //存储图片相关信息
        Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
        //设置图片相关信息 比如 分辨率 边距 编码格式等
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        hints.put(EncodeHintType.MARGIN, 1);
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        try {
            //创建位图矩阵 参数说明：1、二维码 内容2、要生成的格式 3、宽 4、高 5、相关信息
            return new MultiFormatWriter().encode(msg,
                    BarcodeFormat.QR_CODE, width, width, hints);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * @param content 二维码的内容
     * @param width 二维码的大小*/
    public static BufferedImage createColor(String content,int width){
        //定义二维码内容参数
        Map<EncodeHintType, Object> hints = new HashMap<>();
        //设置字符集编码格式
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        hints.put(EncodeHintType.MARGIN, 1);
        //设置容错等级，在这里我们使用M级别
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        // 生成二维码，参数顺序分别为：编码内容，编码类型，生成图片宽度，生成图片高度，设置参数
        BitMatrix matrix = null;
        try {
            matrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, width, hints);
        } catch (WriterException e) {
            e.printStackTrace();
        }
        // 二维矩阵转为一维像素数组
        int halfW = matrix.getWidth() / 2;
        int halfH = matrix.getHeight() / 2;
        int[] pixels = new int[width * width];

        for (int y = 0; y < matrix.getHeight(); y++) {
            for (int x = 0; x < matrix.getWidth(); x++) {
                // 二维码颜色（RGB）
                int num1 = (int) (50 - (50.0 - 13.0) / matrix.getHeight()
                        * (y + 1));
                int num2 = (int) (165 - (165.0 - 72.0) / matrix.getHeight()
                        * (y + 1));
                int num3 = (int) (162 - (162.0 - 107.0)
                        / matrix.getHeight() * (y + 1));
                Color color = new Color(num1, num2, num3);
                int colorInt = color.getRGB();
                // 此处可以修改二维码的颜色，可以分别制定二维码和背景的颜色；
                pixels[y * width + x] = matrix.get(x, y) ? colorInt : 16777215;// 0x000000:0xffffff
            }
        }
        BufferedImage image = new BufferedImage(width, width, BufferedImage.TYPE_INT_RGB);
        image.getRaster().setDataElements(0, 0, width, width, pixels);
        return image;
    }
    /**
     * 实现二维码的生成*/
    public static void createQRcode(String msg,int width,String filePath) {
        //1、设置信息  二维码的信息 边距
        Map<EncodeHintType, Object> hits = new HashMap<>();
        hits.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        hits.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        hits.put(EncodeHintType.MARGIN, 1);

        try {
            //2、创建ZXing核心对象
            BitMatrix matrix = new MultiFormatWriter().encode(msg, BarcodeFormat.QR_CODE, width, width, hits);
            //设置颜色 0 或1  黑白色
            MatrixToImageConfig config = new MatrixToImageConfig(0xFF000001, 0xFFFFFFFF);
            //生成缓存图片
            BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(matrix, config);
            //3、生成二维码图片
            ImageIO.write(bufferedImage, "png", new File(filePath));
            System.out.println("二维码生成成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static BufferedImage createQRcode(String msg,int width){
        //1、设置信息  二维码的信息 边距
        Map<EncodeHintType, Object> hits = new HashMap<>();
        hits.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        hits.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        hits.put(EncodeHintType.MARGIN, 1);
        try {
            //2、创建ZXing核心对象
            BitMatrix matrix = new MultiFormatWriter().encode(msg, BarcodeFormat.QR_CODE, width, width, hits);
            //设置颜色 0 或1  黑白色
            MatrixToImageConfig config = new MatrixToImageConfig(0xFF000001, 0xFFFFFFFF);
            //生成缓存图片
            BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(matrix, config);
            return bufferedImage;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



    //测试二维码生成
    public static void main(String[] args) {
        createQRcode("起来吧",400,"qilaiba.png");
    }
}
