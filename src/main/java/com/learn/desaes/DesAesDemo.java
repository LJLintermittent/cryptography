package com.learn.desaes;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Description:
 * date: 2021/2/9 20:30
 * Package: com.learn.desaes
 *
 * @author 李佳乐
 * @version 1.0
 */
public class DesAesDemo {
    public static void main(String[] args) throws Exception {
        //原文
        String input = "我爱学习";
        //使用DES进行加密，密钥必须为八个字节
        //使用AES进行加密，密钥必须为十六个字节
        String key = "12345678";
        // 算法/加密模式/填充模式
//        String transformation = "DES/ECB/PKCS5Padding";
        String transformation = "DES/CBC/PKCS5Padding";
        //加密类型
        String algorithm = "DES";
        String encryptDES = encryptDES(input, key, transformation, algorithm);
        System.out.println("加密:" + encryptDES);

        String decryptDES = decryptDES(encryptDES, key, transformation, algorithm);
        System.out.println("解密:" + decryptDES);

    }

    /**
     * 解密方法
     *
     * @param encryptDES     密文
     * @param key            密钥
     * @param transformation 加密算法
     * @param algorithm      加密类型
     * @return
     * @throws Exception
     */
    private static String decryptDES(String encryptDES, String key, String transformation, String algorithm) throws Exception {
        Cipher cipher = Cipher.getInstance(transformation);
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), algorithm);
        IvParameterSpec iv = new IvParameterSpec(key.getBytes());
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, iv);
        byte[] bytes = cipher.doFinal(Base64.decode(encryptDES));
        return new String(bytes);
    }

    /**
     * 加密方法
     *
     * @param input          原文
     * @param key            密钥
     * @param transformation 加密算法
     * @param algorithm      加密类型
     * @return
     * @throws Exception
     */
    private static String encryptDES(String input, String key, String transformation, String algorithm) throws Exception {
        //创建加密对象
        Cipher cipher = Cipher.getInstance(transformation);
        //创建加密规则
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), algorithm);
        //iv向量也必须是八个字节
        IvParameterSpec iv = new IvParameterSpec(key.getBytes());
        //加密初始化(加密模式，加密规则)
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, iv);
        //调用加密方法
        byte[] bytes = cipher.doFinal(input.getBytes());
        String encode = Base64.encode(bytes);
        return encode;
    }
}
