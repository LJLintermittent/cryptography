package com.learn.digest;

import com.learn.rsa.RSADemo2;
import com.sun.org.apache.xml.internal.security.utils.Base64;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;

/**
 * Description:
 * date: 2021/2/10 20:52
 * Package: com.learn.digest
 *
 * @author 李佳乐
 * @version 1.0
 */
public class SignatureDemo {
    public static void main(String[] args) throws Exception {
        String input = "123";
        PrivateKey privateKey = RSADemo2.getPrivateKey("a.pri", "RSA");
        PublicKey publicKey = RSADemo2.getPublicKey("a.pub", "RSA");
        String signatureData = getSignature(input, "sha256withrsa", privateKey);
        System.out.println(signatureData);
        boolean b = verifySignature(input, "sha256withrsa", publicKey, signatureData);
        System.out.println(b);
    }

    /**
     * 校验数字签名
     *
     * @param input         原文
     * @param algorithm     算法
     * @param publicKey     公钥
     * @param signatureData 数字签名密文
     * @return
     */
    private static boolean verifySignature(String input, String algorithm, PublicKey publicKey, String signatureData) throws Exception {
        Signature signature = Signature.getInstance(algorithm);
        signature.initVerify(publicKey);
        signature.update(input.getBytes());
        return signature.verify(Base64.decode(signatureData));
    }

    /**
     * 生成数字签名
     *
     * @param input      原文
     * @param algorithm  算法
     * @param privateKey 私钥
     * @return
     */
    private static String getSignature(String input, String algorithm, PrivateKey privateKey) throws Exception {
        Signature signature = Signature.getInstance(algorithm);
        signature.initSign(privateKey);
        signature.update(input.getBytes());
        byte[] bytes = signature.sign();
        return Base64.encode(bytes);
    }
}
