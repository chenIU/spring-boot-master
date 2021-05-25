package com.ruida.springbootdemo.utils;

import com.ruida.springbootdemo.enums.ErrorEnum;
import com.ruida.springbootdemo.exception.BaseException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

/**
 * @author Chen.J.Y
 * @date 2021/5/25
 * @desc RSA加解密
 */
public class RSAUtil {

    private static final String CHARSET = "UTF-8";
    private static final String ALGORITHM = "RSA";

    /**
     * 针对长文本进行加解密时，需要分段处理
     */
    // 加密时 最大加密块
    private static final int MAX_ENCRYPT_BLOCK = 117;
    // 加密时 最大解密块
    private static final int MAX_DECRYPT_BLOCK = 118;

    //默认的公私钥 每次项目重启时都会重置
    private static final RSABean DEFAULT_KEY = createRSA();

    /**
     * 生成公私钥对
     */
    public static RSABean createRSA() {
        try {
            //实例化密钥生成器
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(ALGORITHM);
            //密钥长度 长度越大越安全 但加解密也会越慢
            keyPairGenerator.initialize(1024);
            //生成密钥对
            KeyPair keyPair = keyPairGenerator.generateKeyPair();

            //公钥
            RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
            String publicKeyStr = Base64.getEncoder().encodeToString(publicKey.getEncoded());

            //私钥
            RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
            String privateKeyStr = Base64.getEncoder().encodeToString(privateKey.getEncoded());

            RSABean rsaBean = new RSABean();
            rsaBean.setPublicKey(publicKey);
            rsaBean.setPublicKeyStr(publicKeyStr);
            rsaBean.setPrivateKey(privateKey);
            rsaBean.setPrivateKeyStr(privateKeyStr);
            return rsaBean;
        } catch (NoSuchAlgorithmException e) {
            throw new BaseException(ErrorEnum.ERROR, "RSA密钥对生成失败");
        }
    }

    //获取默认密钥对
    public static RSABean getDefaultKey() {
        return DEFAULT_KEY;
    }

    /**
     * 私钥加密
     */
    public static byte[] privateEncrypt(byte[] content, byte[] privateKey) throws Exception {
        PrivateKey privateK = KeyFactory.getInstance(ALGORITHM).generatePrivate(new PKCS8EncodedKeySpec(privateKey));
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, privateK);
        return shardingProcess(content, cipher, MAX_ENCRYPT_BLOCK);
    }

    public static byte[] privateEncrypt(byte[] content, String privateKey) throws Exception {
        byte[] privateKeyBytes = Base64.getDecoder().decode(privateKey);
        return privateEncrypt(content, privateKeyBytes);
    }

    public static String privateEncrypt(String content, String privateKey) throws Exception {
        byte[] privateKeyBytes = Base64.getDecoder().decode(privateKey);
        byte[] contentBytes = content.getBytes(CHARSET);
        byte[] bytes = privateEncrypt(contentBytes, privateKeyBytes);
        return Base64.getEncoder().encodeToString(bytes);
    }

    /**
     * 私钥解密
     */
    public static byte[] privateDecrypt(byte[] content, byte[] privateKey) throws Exception {
        PrivateKey privateK = KeyFactory.getInstance(ALGORITHM).generatePrivate(new PKCS8EncodedKeySpec(privateKey));
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, privateK);
        return shardingProcess(content, cipher, MAX_DECRYPT_BLOCK);
    }

    public static byte[] privateDecrypt(byte[] content, String privateKey) throws Exception {
        byte[] privateKeyBytes = Base64.getDecoder().decode(privateKey);
        return privateDecrypt(content, privateKeyBytes);
    }

    public static String privateDecrypt(String content, String privateKey) throws Exception {
        byte[] privateKeyBytes = Base64.getDecoder().decode(privateKey);
        byte[] contentBytes = Base64.getDecoder().decode(content);
        byte[] bytes = privateDecrypt(contentBytes, privateKeyBytes);
        return new String(bytes, CHARSET);
    }

    /**
     * 公钥加密
     */
    public static byte[] publicEncrypt(byte[] content, byte[] publicKey) throws Exception {
        RSAPublicKey publicK = (RSAPublicKey) KeyFactory.getInstance(ALGORITHM).generatePublic(new X509EncodedKeySpec(publicKey));
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, publicK);
        return shardingProcess(content, cipher, MAX_ENCRYPT_BLOCK);
    }

    public static byte[] publicEncrypt(byte[] content, String publicKey) throws Exception {
        byte[] publicKeyBytes = Base64.getDecoder().decode(publicKey);
        return publicEncrypt(content, publicKeyBytes);
    }

    public static String publicEncrypt(String content, String publicKey) throws Exception {
        byte[] publicKeyBytes = Base64.getDecoder().decode(publicKey);
        byte[] contentBytes = content.getBytes(CHARSET);
        byte[] bytes = publicEncrypt(contentBytes, publicKeyBytes);
        return Base64.getEncoder().encodeToString(bytes);
    }

    /**
     * 公钥解密
     */
    public static byte[] publicDecrypt(byte[] content, byte[] publicKey) throws Exception {
        PublicKey publicK = KeyFactory.getInstance(ALGORITHM).generatePublic(new X509EncodedKeySpec(publicKey));
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, publicK);
        return shardingProcess(content, cipher, MAX_DECRYPT_BLOCK);
    }

    public static byte[] publicDecrypt(byte[] content, String publicKey) throws Exception {
        byte[] publicKeyBytes = Base64.getDecoder().decode(publicKey);
        return publicDecrypt(content, publicKeyBytes);
    }

    public static String publicDecrypt(String content, String publicKey) throws Exception {
        byte[] publicKeyBytes = Base64.getDecoder().decode(publicKey);
        byte[] contentBytes = Base64.getDecoder().decode(content);
        byte[] bytes = publicDecrypt(contentBytes, publicKeyBytes);
        return new String(bytes, CHARSET);
    }

    /**
     * 分块进行加解密
     */
    private static byte[] shardingProcess(byte[] content, Cipher cipher, int MAX_BLOCK) throws IllegalBlockSizeException, BadPaddingException {
        int len = content.length;
        // 标识
        int offSet = 0;

        // 用一个list 存储各分段计算 生成的byte数组
        List<byte[]> tempList = new ArrayList<>();
        // 最终byte数组  应有的总长度
        int resultLength = 0;

        // 分段加解密
        byte[] cache;
        while (len - offSet > 0) {
            if (len - offSet > MAX_BLOCK) {
                cache = cipher.doFinal(content, offSet, MAX_BLOCK);
                offSet += MAX_BLOCK;
            } else {
                cache = cipher.doFinal(content, offSet, len - offSet);
                offSet = len;
            }
            resultLength += cache.length;
            tempList.add(cache);
        }

        // 拼接总数组
        byte[] resultBytes = new byte[resultLength];
        int resultOffset = 0;
        for (byte[] bytes : tempList) {
            System.arraycopy(bytes, 0, resultBytes, resultOffset, bytes.length);
            resultOffset += bytes.length;
        }
        return resultBytes;
    }

    public static class RSABean {
        private RSAPublicKey publicKey;
        private String publicKeyStr;

        private RSAPrivateKey privateKey;
        private String privateKeyStr;

        public RSAPublicKey getPublicKey() {
            return publicKey;
        }

        public void setPublicKey(RSAPublicKey publicKey) {
            this.publicKey = publicKey;
        }

        public String getPublicKeyStr() {
            return publicKeyStr;
        }

        public void setPublicKeyStr(String publicKeyStr) {
            this.publicKeyStr = publicKeyStr;
        }

        public RSAPrivateKey getPrivateKey() {
            return privateKey;
        }

        public void setPrivateKey(RSAPrivateKey privateKey) {
            this.privateKey = privateKey;
        }

        public String getPrivateKeyStr() {
            return privateKeyStr;
        }

        public void setPrivateKeyStr(String privateKeyStr) {
            this.privateKeyStr = privateKeyStr;
        }
    }
}
