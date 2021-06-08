package com.learn.digest;

import com.sun.org.apache.xml.internal.security.utils.Base64;

import java.security.MessageDigest;

/**
 * Description:
 * date: 2021/2/10 14:57
 * Package: com.learn.digest
 *
 * @author 李佳乐
 * @version 1.0
 */

//4124bc0a9335c27f086f24ba207a4912
//4124bc0a9335c27f086f24ba207a4912
public class DigestDemo01 {
    public static void main(String[] args) throws Exception {
        String input = "李佳乐";
        String algorithm = "MD5";
        //QSS8CpM1wn8IbyS6IHpJEg==
        //创建加密对象
        String MD5 = getDigest(input, algorithm);
        System.out.println("MD5:" + MD5);

        String sha1 = getDigest(input, "SHA-1");
        System.out.println("sha1:" + sha1);

        String sha256 = getDigest(input, "SHA-256");
        System.out.println("sha256:" + sha256);

        String sha512 = getDigest(input, "SHA-512");
        System.out.println("sha512:" + sha512);
//        System.out.println(new String(digest));
        //使用base64转码
//        System.out.println(Base64.encode(digest));
    }

    /**
     * 获取数字摘要
     *
     * @param input     原文
     * @param algorithm 算法
     * @return
     * @throws Exception
     */
    private static String getDigest(String input, String algorithm) throws Exception {
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        //执行消息摘要算法
        byte[] digest = messageDigest.digest(input.getBytes());
        return toHex(digest);
    }

    /**
     * 转换成hash值
     *
     * @param digest 数字摘要
     * @return
     */
    private static String toHex(byte[] digest) {
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            //把密文转化成十六进制
            String s = Integer.toHexString(b & 0xff);
            if (s.length() == 1) {
                s = "0" + s;
            }
            sb.append(s);
        }
        return sb.toString();
    }
}
