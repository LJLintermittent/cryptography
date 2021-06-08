package com.learn.rsa;

import com.sun.org.apache.xml.internal.security.utils.Base64;

import javax.crypto.Cipher;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * Description:
 * date: 2021/2/10 16:58
 * Package: com.learn.rsa
 *
 * @author 李佳乐
 * @version 1.0
 */
public class RSADemo {
    public static void main(String[] args) throws Exception {
        String input = "硅谷";
        String algorithm = "RSA";
        //创建密钥对生成器对象
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(algorithm);
        //生成密钥对
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        //生成私钥
        PrivateKey privateKey = keyPair.getPrivate();
        //生成公钥
        PublicKey publicKey = keyPair.getPublic();
        //获取公私钥字节数组
        byte[] privateKeyEncoded = privateKey.getEncoded();
        byte[] publicKeyEncoded = publicKey.getEncoded();
        String privateEncodeString = Base64.encode(privateKeyEncoded);
        String publicEncodeString = Base64.encode(publicKeyEncoded);
        System.out.println("****************打印私钥************");
        System.out.println(privateEncodeString);
        System.out.println("****************打印公钥***********");
        System.out.println(publicEncodeString);

        System.out.println("*****************打印私钥加密后的密文************");
        //使用私钥进行加密
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
        byte[] bytes = cipher.doFinal(input.getBytes());
        System.out.println(Base64.encode(bytes));

        System.out.println("******************打印公钥解密后的密文*******");

        //使用公钥进行解密
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        byte[] bytes1 = cipher.doFinal(bytes);
        System.out.println(new String(bytes1));

    }

}
