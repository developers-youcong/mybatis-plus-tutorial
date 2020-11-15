package com.blog.tutorial.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blog.tutorial.entity.Users;
import com.blog.tutorial.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @PostMapping("/del")
    public Map del(Integer id) {
        Map<String, Object> returnMap = new HashMap<>();

        returnMap.put("code", "200");
        returnMap.put("msg", "删除成功");

        usersService.removeById(id);

        return returnMap;
    }

    @GetMapping("/list")
    public Map list(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {

        Map<String, Object> returnMap = new HashMap<>();

        Page<Users> page = new Page<>(pageNum, pageSize);

        IPage<Users> data = usersService.selectUserPage(page);

        returnMap.put("count", data.getTotal());

        returnMap.put("data", data.getRecords());

        return returnMap;

    }

}
