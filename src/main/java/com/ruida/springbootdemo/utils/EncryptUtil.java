package com.ruida.springbootdemo.utils;

import org.apache.commons.codec.binary.Hex;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Chen.J.Y
 * @date 2021/4/20
 */
public class EncryptUtil {

    public static String encryptPassword(String username, String password) {
        username = username == null ? "" : username;
        password = password == null ? "" : password;
        ByteSource credentialsSalt = ByteSource.Util.bytes(username);
        return new SimpleHash("MD5", password, credentialsSalt, 2).toHex();
    }

    public static String md5(String content) {
        return encrypt("MD5", content);
    }

    public static String sha1(String content) {
        return encrypt("SHA-1", content);
    }

    public static String sha256(String content) {
        return encrypt("SHA-256", content);
    }

    private static String encrypt(String algo, String content) {
        try {
            MessageDigest instance = MessageDigest.getInstance(algo);
            instance.update(content.getBytes());
            byte[] digest = instance.digest();
            int i;
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                i = b;
                if (i < 0) {
                    i += 256;
                }
                if (i < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(i));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取字节流的MD5值
     *
     * @param bytes
     * @return
     */
    public static String getBytesMD5(byte[] bytes) {
        String hashString = "";
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] digest = md5.digest(bytes);
            hashString = new String(Hex.encodeHex(digest));
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        return hashString;
    }
}
