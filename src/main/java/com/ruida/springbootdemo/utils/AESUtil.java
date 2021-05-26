package com.ruida.springbootdemo.utils;

import com.ruida.springbootdemo.enums.ErrorEnum;
import com.ruida.springbootdemo.exception.BaseException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.Security;
import java.security.spec.AlgorithmParameterSpec;

/**
 * @author Chen.J.Y
 * @date 2021/5/25
 */
@Slf4j
public class AESUtil {
    private static final String CHARSET_NAME = "UTF-8";
    private static final String AES_NAME = "AES";
    public static final String ALGORITHM = "AES/CBC/PKCS7Padding";

    //加载加解密扩展依赖
    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    /**
     * 加密
     *
     * @param content string 加密内容
     * @param key     string 密钥
     * @return string 密文
     */
    public static String encrypt(String content, String key) {
        if (StringUtils.isNotBlank(content) && StringUtils.isNotBlank(key)) {
            byte[] result = null;
            try {
                Cipher cipher = Cipher.getInstance(ALGORITHM);
                SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(CHARSET_NAME), AES_NAME);
                AlgorithmParameterSpec paramSpec = new IvParameterSpec(key.substring(0, 16).getBytes(CHARSET_NAME));
                cipher.init(Cipher.ENCRYPT_MODE, keySpec, paramSpec);
                result = cipher.doFinal(content.getBytes(CHARSET_NAME));
            } catch (Exception ex) {
                log.error("AES加密失败 content:" + content, ex);
            }
            return Base64.encodeBase64String(result);
        }
        return null;
    }

    /**
     * 解密
     *
     * @param content string 加密内容
     * @param key     string 密钥
     * @return string 明文
     */
    public static String decrypt(String content, String key) {
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(CHARSET_NAME), AES_NAME);
            AlgorithmParameterSpec paramSpec = new IvParameterSpec(key.substring(0, 16).getBytes());
            cipher.init(Cipher.DECRYPT_MODE, keySpec, paramSpec);
            return new String(cipher.doFinal(Base64.decodeBase64(content)), CHARSET_NAME);
        } catch (Exception ex) {
            throw new BaseException(ErrorEnum.ERROR, "密文：" + content + " AES解密失败");
        }
    }

}
