package com.blog.tutorial07.shiro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @description:-
 * @author: youcong
 * @time: 2020/11/15 11:26
 */
@SpringBootApplication
@MapperScan("com.blog.tutorial07.shiro.dao")
public class ShiroApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShiroApplication.class, args);
        System.out.println("====服务启动成功====");
    }
}
