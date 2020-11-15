package com.blog.tutorial.controller;

import com.blog.tutorial.entity.Users;
import com.blog.tutorial.service.UsersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = {"用户管理"}, description = "用户管理")
public class UserController {


    @Autowired
    private UsersService usersService;


    @GetMapping("/list")
    @ApiOperation(value = "用户列表")
    public List<Users> list() {

        return usersService.list();

    }


}
