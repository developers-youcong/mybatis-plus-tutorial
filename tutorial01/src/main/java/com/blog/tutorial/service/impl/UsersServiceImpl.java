package com.blog.tutorial.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.tutorial.dao.UsersDao;
import com.blog.tutorial.entity.Users;
import com.blog.tutorial.service.UsersService;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: youcong
 * @time: 2020/11/14 13:27
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersDao, Users> implements UsersService {
}
