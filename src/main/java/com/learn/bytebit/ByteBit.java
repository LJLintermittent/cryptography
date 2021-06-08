package com.learn.bytebit;

import org.junit.Test;

import java.io.UnsupportedEncodingException;

/**
 * Description:
 * date: 2021/2/9 20:06
 * Package: com.learn.bytebit
 *
 * @author 李佳乐
 * @version 1.0
 */
public class ByteBit {
    public static void main(String[] args) {
        String a = "a";
        byte[] bytes = a.getBytes();
        for (byte aByte : bytes) {
            int c = aByte;
            System.out.println(aByte);
            String s = Integer.toBinaryString(c);
            System.out.println(s);
        }
    }

    //在utf-8编码中，一个中文对应三个字节
    //在GBK编码中，一个中文对应两个字节
    @Test
    public void demo02() throws UnsupportedEncodingException {
        String a = "李";
        byte[] bytes = a.getBytes();
        for (byte aByte : bytes) {
            System.out.println(aByte);
            String s = Integer.toBinaryString(aByte);
            System.out.println(s);
        }
    }
}
