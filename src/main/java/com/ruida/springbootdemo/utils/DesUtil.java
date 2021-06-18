package com.ruida.springbootdemo.utils;

import cn.hutool.crypto.Mode;
import cn.hutool.crypto.Padding;
import cn.hutool.crypto.symmetric.DES;
import org.springframework.util.StringUtils;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;

/**
 * <p>
 * DES加密解密工具类 用于和.net对接
 * </p>
 *
 * @author wzw
 * @since 2020-10-27
 */
public class DesUtil {

    /**
     * DES加密 匹配.net那边
     *
     * @param encryptedString 需要加密的字符串
     * @return 加密后的字符串
     */
    public static String encryptString(String encryptedString) {
        return encrypt(encryptedString);
    }

    /**
     * DES解密 匹配.net那边
     *
     * @param inputConnectionString 需要解密的密文
     * @return 加密前的字符串
     */
    public String decryptString(String inputConnectionString) {
        if (StringUtils.isEmpty(inputConnectionString)) {
            return inputConnectionString;
        }
        return decrypt(inputConnectionString);
    }

    private String decrypt(String pToDecrypt) {
        byte[] key = getKey();
        DES des = new DES(Mode.CBC, Padding.PKCS5Padding, key, key);
        byte[] buffer = new byte[pToDecrypt.length() / 2];
        for (int i = 0; i < (pToDecrypt.length() / 2); i++) {
            BigInteger bigint = new BigInteger(pToDecrypt.substring(i * 2, (i * 2) + 2), 16);
            int num2 = bigint.intValue();
            buffer[i] = (byte) num2;
        }
        byte[] decrypt = des.decrypt(buffer);
        return new String(decrypt);
    }


    /**
     * DES加密 匹配.net那边
     *
     * @param pToEncrypt 需要加密的字符串
     * @return 加密后的字符串
     */
    private static String encrypt(String pToEncrypt) {
        byte[] bytes = pToEncrypt.getBytes();
        byte[] key = getKey();
        DES des = new DES(Mode.CBC, Padding.PKCS5Padding, key, key);
        byte[] encrypt = des.encrypt(bytes);
        StringBuilder aa = new StringBuilder();
        for (byte b1 : encrypt) {
            int b2 = (int) b1;
            if (b2 < 0) {
                b2 = 256 + b2;
            }
            String format = String.format("%02x", b2);
            aa.append(format);
        }
        return aa.toString().toUpperCase();
    }

    private static byte[] getKey() {
        String sKey = "";
        int[] numArray = new int[]{0x1b, 0xba, 0xc3, 0xa5, 0xc9, 240, 0xd1, 0xbb};
        for (int num : numArray) {
            sKey = sKey + (char) num;
        }
        return sKey.getBytes(StandardCharsets.US_ASCII);
    }

    public static void main(String[] args) {
        System.out.println(encryptString("PDrGGpkFuxvj6SsHloaQtFmJABfjIp5X" + "1624001946057"));
    }


}

