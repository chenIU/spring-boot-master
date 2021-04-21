package com.ruida.springbootdemo.utils;

import org.apache.commons.codec.binary.Hex;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Chen.J.Y
 * @date 2021/4/20
 */
public class EncryptUtil {

    /**
     * 获取字节流的MD5值
     * @param bytes
     * @return
     */
    public static String getBytesMD5(byte[] bytes){
        String hashString = "";
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] digest = md5.digest(bytes);
            hashString = new String(Hex.encodeHex(digest));
        }catch (NoSuchAlgorithmException ex){
            ex.printStackTrace();
        }
        return hashString;
    }
}
