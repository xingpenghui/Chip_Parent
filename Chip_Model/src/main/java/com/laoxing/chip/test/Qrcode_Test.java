package com.laoxing.chip.test;

import com.laoxing.chip.dto.CardDto;
import com.laoxing.chip.util.Base64Util;
import com.laoxing.chip.util.PhoneVcardUtil;
import com.laoxing.chip.util.QRcodeUtil;

/**
 * @program: Chip_Parent
 * @description:
 * @author: Feri
 * @create: 2020-02-12 15:55
 */
public class Qrcode_Test {
    public static void main(String[] args) {
        CardDto dto=new CardDto();
        dto.setAddress("武汉");
        dto.setBlogurl("http://www.baidu.com");
        dto.setEmail("xph@163.com");
        dto.setInfo("做真实的自己");
        dto.setName("杨老师");
        dto.setPhone("11212121");
        dto.setPosition("千锋讲师");
        String str=PhoneVcardUtil.createPV(dto); //转换为手机识别的字符串格式
        System.out.println("原生："+str);
        String p= Base64Util.base64UrlEnc(str);
        System.out.println("base64url:"+p);
        System.out.println("解码："+Base64Util.base64UrlDec(p));
       // QRcodeUtil.createQRcode(PhoneVcardUtil.createPV(dto),400,"lxr.png");
    }

}
