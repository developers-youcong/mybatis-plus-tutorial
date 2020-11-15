package com.blog.tutorial06.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.blog.tutorial06.entity.Users;
import com.blog.tutorial06.dao.UsersDao;
import com.blog.tutorial06.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: youcong
 * @time: 2020/11/14 13:27
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersDao, Users> implements UsersService {

    @Autowired
    private UsersDao usersDao;

    @Override
    public int add(Users user) {

        return usersDao.insert(user);
    }

    @Override
    public int del(Long id) {
        return usersDao.deleteById(id);
    }

    @Override
    public int modify(Users user) {
        return usersDao.updateById(user);
    }

    @Override
    public List<Users> selectAll() {

        return usersDao.selectList(null);
    }
}
