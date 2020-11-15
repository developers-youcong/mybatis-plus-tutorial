package com.blog.tutorial06.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.blog.tutorial06.entity.Users;

import java.util.List;

/**
 * @description:
 * @author: youcong
 * @time: 2020/11/14 13:26
 */
public interface UsersService extends IService<Users> {


    int add(Users user);

    int del(Long id);

    int modify(Users user);

    List<Users> selectAll();
}
