package com.learn.kaiser;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/2/9 17:50<br/>
 *
 * @author ${李佳乐}<br/>
 * @since JDK 1.8
 */
public class KaiserDemo {
    public static void main(String[] args) {
        String a = "十二月五号晚上八点进攻";
        int key  = 3;
        System.out.println("原文:" + a);
        String s = encrypt(a, key);
        System.out.println("密文:" + s);
        String s1 = decrypt(s,key);
        System.out.println("明文:" + s1);
    }
    //解密
    public static String decrypt(String s, int key) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char aChar : chars) {
            int b = aChar;
            b = b - key;
            char newb = (char) b;
            sb.append(newb);
        }
        return sb.toString();
    }
    //加密
    public static String encrypt(String a, int key) {
        char[] chars = a.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char aChar : chars) {
            int b = aChar;
            b = b + key;
            char newb = (char) b;
            sb.append(newb);
        }
        return sb.toString();
    }
}
