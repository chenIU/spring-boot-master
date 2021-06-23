package com.ruida.springbootdemo.utils;

import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.security.spec.AlgorithmParameterSpec;

/**
 * @author Chen.J.Y
 * @date 2021/6/22
 * 密码：JAVA中有效密码为16位/24位/32位
 * 数据块：128位/192位/256位
 * 偏移量：ECB不需要设置
 */
public class AesUtil {

    /**
     * 加密算法
     */
    private static final String ENCRYPT_ALGORITHM = "AES";

    /**
     * 加密算法/加密模式/填充类型
     * 加密模式：ECB/CBC/CTR/OFB/CFB
     * 填充：pkcs5padding/pkcs7padding/zeropadding/iso10126/ansix923
     */
    private static final String CIPHER_MODE = "AES/CBC/PKCS7Padding";

    /**
     * 字符集
     */
    private static final String CHAR_SET = "UTF-8";

    /**
     * 密码长度，不足此长度补0
     */
    private static final int SIZE = 16;

    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    private static byte[] preHandler(String key) throws UnsupportedEncodingException {
        byte[] data = null;
        if (key != null) {
            byte[] bytes = key.getBytes(CHAR_SET);
            if (bytes.length < SIZE) {
                System.arraycopy(bytes, 0, data = new byte[SIZE], 0, bytes.length);
            } else {
                data = bytes;
            }
        }
        return data;
    }

    public static String encrypt(String plainText, String key) {
        try {
            byte[] keyBytes = preHandler(key);

            // 1.获取加密密钥
            SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, ENCRYPT_ALGORITHM);

            // 2.获取Cipher实例
            Cipher cipher = Cipher.getInstance(CIPHER_MODE);

            // 3.设置偏移量
            AlgorithmParameterSpec paramSpec = new IvParameterSpec(keyBytes, 0, 16);

            // 4.初始化Cipher实列，设置执行模式及加密密钥
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, paramSpec);

            // 5.执行并返回结果
            return Base64.encodeBase64String(cipher.doFinal(plainText.getBytes(CHAR_SET)));

        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException | InvalidAlgorithmParameterException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String decrypt(String cipherText, String key) {
        try {
            byte[] keyBytes = preHandler(key);
            // 1.获取加密密钥
            SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, ENCRYPT_ALGORITHM);

            // 2.获取Cipher实例
            Cipher cipher = Cipher.getInstance(CIPHER_MODE);

            // 3.设置偏移量
            AlgorithmParameterSpec paramSpec = new IvParameterSpec(keyBytes, 0, 16);

            // 4.初始化Cipher实列，设置执行模式及加密密钥
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, paramSpec);

            // 5.执行并返回结果
            return new String(cipher.doFinal(Base64.decodeBase64(cipherText)), CHAR_SET);

        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException | InvalidAlgorithmParameterException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void main(String[] args) {
        String key = "123456";
        System.out.println(encrypt("chenjy", key));
        System.out.println(decrypt("R8JIjXkhSltUwFJ4kylFHg==", key));
    }
}
