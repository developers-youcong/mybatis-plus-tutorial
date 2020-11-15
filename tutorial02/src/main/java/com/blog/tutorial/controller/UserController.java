package com.blog.tutorial.controller;

import com.blog.tutorial.entity.Users;
import com.blog.tutorial.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: youcong
 * @time: 2020/11/14 13:27
 */
@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UsersService usersService;

    @Autowired
    private RedisTemplate redisTemplate;


    @GetMapping("/list")
    public String list() {

        System.out.println("list:"+redisTemplate.opsForValue().get("list"));
        if (StringUtils.isEmpty(redisTemplate.opsForValue().get("list"))) {
            redisTemplate.opsForValue().set("list", usersService.list(), 360, TimeUnit.MINUTES);
        }
        return redisTemplate.opsForValue().get("list").toString();

    }


}
