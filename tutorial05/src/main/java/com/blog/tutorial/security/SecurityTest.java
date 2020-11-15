package com.blog.tutorial.security;

import com.baomidou.mybatisplus.core.toolkit.AES;

/**
 * @description:
 * @author: youcong
 * @time: 2020/11/14 21:50
 */
public class SecurityTest {
    public static void main(String[] args) {
        //生成 16 位随机 AES 密钥
        String randomKey = AES.generateRandomKey();

        String data = "jdbc:mysql://127.0.0.1:3306/wordpress_test?useUnicode=true&characterEncoding=utf-8&serverTimeZone=GMT";
        //随机密钥加密
        String result = AES.encrypt(data, randomKey);

        System.out.println("result:"+result);
    }
}
