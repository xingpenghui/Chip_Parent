package com.laoxing.chip.util;

import java.util.Base64;

/**
 * @program: Chip_Parent
 * @description: 封装编码格式 常用的base64 base64URL
 * @author: Feri
 * @create: 2020-02-12 16:03
 */
public class Base64Util {
    //编码 base64Url
    public static String base64UrlEnc(String msg){
        return Base64.getUrlEncoder().encodeToString(msg.getBytes());
    }
    //解码 base64Url
    public static String base64UrlDec(String msg){
        return new String(Base64.getUrlDecoder().decode(msg));
    }
    //编码 base64
    public static String base64Enc(String msg){
        return Base64.getEncoder().encodeToString(msg.getBytes());
    }
    //解码 base64
    public static String base64Dec(String msg){
        return new String(Base64.getDecoder().decode(msg));
    }
}
