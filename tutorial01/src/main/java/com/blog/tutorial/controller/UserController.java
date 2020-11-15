package com.blog.tutorial.controller;

import com.blog.tutorial.entity.Users;
import com.blog.tutorial.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping("/list")
    public List<Users> list() {
        return usersService.list();

    }

}
