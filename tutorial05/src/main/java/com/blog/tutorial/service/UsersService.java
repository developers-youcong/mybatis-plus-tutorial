package com.blog.tutorial.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.blog.tutorial.entity.Users;

/**
 * @description:
 * @author: youcong
 * @time: 2020/11/14 13:26
 */
public interface UsersService extends IService<Users> {

    IPage<Users> selectUserPage(Page<Users> page);
}
