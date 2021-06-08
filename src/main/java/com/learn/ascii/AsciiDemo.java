package com.learn.ascii;

import org.junit.Test;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/2/9 17:31<br/>
 *
 * @author ${李佳乐}<br/>
 * @since JDK 1.8
 */
public class AsciiDemo {
    public static void main(String[] args) {
        char a = 'A';
        int b = a;
        System.out.println(b);
    }

    @Test
    public void test2(){
        String a = "AaZ";
        char[] chars = a.toCharArray();
        for (char aChar : chars) {
            int asciiCode = aChar;
            System.out.println(asciiCode);
        }
    }

}
