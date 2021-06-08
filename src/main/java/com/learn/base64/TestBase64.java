package com.learn.base64;

import com.sun.org.apache.xml.internal.security.utils.Base64;

/**
 * Description:
 * date: 2021/2/10 12:21
 * Package: com.learn.base64
 *
 * @author 李佳乐
 * @version 1.0
 */
public class TestBase64 {
    public static void main(String[] args) {
        //使用base64进行编码时，如果一组不够三个字节，需要使用=进行补齐
        System.out.println(Base64.encode("1".getBytes()));
        System.out.println(Base64.encode("12".getBytes()));
        System.out.println(Base64.encode("123".getBytes()));
        System.out.println(Base64.encode("李佳乐".getBytes()));
    }
}
