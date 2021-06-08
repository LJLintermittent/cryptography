package com.learn.string;

import com.sun.org.apache.xml.internal.security.utils.Base64;

/**
 * Description:
 * date: 2021/2/10 12:26
 * Package: com.learn.string
 *
 * @author 李佳乐
 * @version 1.0
 */
public class TestString {
    public static void main(String[] args) throws Exception {
        String str = "TU0jV0xBTiNVYys5bEdiUjZlNU45aHJ0bTdDQStBPT0jNjQ2NDY1Njk4IzM5OTkwMDAwMzAwMA==";
        String rlt1 = new String(Base64.decode(str));
        String rlt2 = Base64.decode(str).toString();
        System.out.println("new String === " + rlt1);
        System.out.println("toString === " + rlt2);
    }
}
