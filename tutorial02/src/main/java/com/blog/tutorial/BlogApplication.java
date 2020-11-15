package com.blog.tutorial;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @description:
 * @author: youcong
 * @time: 2020/11/14 11:32
 */

@EnableTransactionManagement
@SpringBootApplication
@EnableCaching
@MapperScan("com.blog.tutorial.dao")
public class BlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);
        System.out.println("====服务启动成功====");
    }
}
