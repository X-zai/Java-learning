/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package learning.java.example;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/**
 * 加解密文件
 * 
 * @author Rayliu40k
 * @version $Id: Main.java, v 0.1 Aug 17, 2020 11:41:20 AM Rayliu40k Exp $
 */
public class 加解密文件 {

    /**
     * 
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        //原文内容
        String content = "Hello world!";
        //AES加密/解密用的原始密码
        String key = "123456";
        System.out.println("原文：" + content);
        //加密数据, 返回密文
        byte[] cipherBytes = encrypt(content.getBytes(), key.getBytes());
        System.out.println("AES加密后：" + new String(cipherBytes));
        //解密数据, 返回明文
        byte[] plainBytes = decrypt(cipherBytes, key.getBytes());
        //输出解密后的明文: "Hello world!"
        System.out.println("AES解密后：" + new String(plainBytes));
    }

    /**
     * 生成密钥对象
     */
    private static SecretKey generateKey(byte[] key) throws Exception {
        //根据指定的 RNG 算法, 创建安全随机数生成器
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        //设置 密钥key的字节数组 作为安全随机数生成器的种子
        random.setSeed(key);
        //创建 AES算法生成器
        KeyGenerator gen = KeyGenerator.getInstance("AES");
        //初始化算法生成器
        gen.init(128, random);
        //生成AES密钥对象, 也可以直接创建密钥对象: return new SecretKeySpec(key, ALGORITHM);
        return gen.generateKey();
    }

    /**
     * 数据加密: 明文 -> 密文
     */
    public static byte[] encrypt(byte[] plainBytes, byte[] key) throws Exception {
        //生成密钥对象
        SecretKey secKey = generateKey(key);
        //获取 AES 密码器
        Cipher cipher = Cipher.getInstance("AES");
        //初始化密码器（加密模型）
        cipher.init(Cipher.ENCRYPT_MODE, secKey);
        //加密数据, 返回密文
        return cipher.doFinal(plainBytes);
    }

    /**
     * 数据解密: 密文 -> 明文
     */
    public static byte[] decrypt(byte[] cipherBytes, byte[] key) throws Exception {
        //生成密钥对象
        SecretKey secKey = generateKey(key);
        //获取 AES 密码器
        Cipher cipher = Cipher.getInstance("AES");
        //初始化密码器（解密模型）
        cipher.init(Cipher.DECRYPT_MODE, secKey);
        //解密数据, 返回明文
        return cipher.doFinal(cipherBytes);
    }

}
