package com.blog.tutorial06;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @description:
 * @author: youcong
 * @time: 2020/11/14 11:32
 */

@EnableTransactionManagement
@SpringBootApplication
@MapperScan("com.blog.tutorial06.dao")
public class BlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(com.blog.tutorial.BlogApplication.class, args);
        System.out.println("====服务启动成功====");
    }
}