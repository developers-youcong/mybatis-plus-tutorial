package com.blog.tutorial06.controller;

import com.blog.tutorial06.entity.Users;
import com.blog.tutorial06.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description:
 * @author: youcong
 * @time: 2020/11/14 13:27
 */
@RestController
@RequestMapping("/users")
public class UsersController {


    @Autowired
    private UsersService usersService;


    @PostMapping("/save")
    public int save(Users user) {

        return usersService.add(user);
    }

    @DeleteMapping("/del")
    public int del(Long id) {

        return usersService.del(id);
    }

    @PutMapping("/modify")
    public int modify(Users user) {
        return usersService.modify(user);
    }

    @GetMapping("/all")
    public List<Users> all() {
        return usersService.selectAll();

    }


}
