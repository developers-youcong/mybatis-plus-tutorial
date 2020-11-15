package com.blog.tutorial07.shiro.controller;

import com.blog.tutorial07.shiro.entity.Users;
import com.blog.tutorial07.shiro.service.UsersService;
import com.blog.tutorial07.shiro.utils.ShiroUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
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

    /**
     * 登录
     *
     * @Author youcong
     */
    @PostMapping("/login")
    public Map<String, Object> login(@RequestParam String username, @RequestParam String password) {
        Map<String, Object> map = new HashMap<>();
        //进行身份验证
        try {
            //验证身份和登陆
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            //进行登录操作
            subject.login(token);
        } catch (IncorrectCredentialsException e) {
            map.put("code", 500);
            map.put("msg", "用户不存在或者密码错误");
            return map;
        } catch (LockedAccountException e) {
            map.put("code", 500);
            map.put("msg", "登录失败，该用户已被冻结");
            return map;
        } catch (AuthenticationException e) {
            map.put("code", 500);
            map.put("msg", "该用户不存在");
            return map;
        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", "未知异常");
            return map;
        }
        map.put("code", 0);
        map.put("msg", "登录成功");
        map.put("token", ShiroUtils.getSession().getId().toString());
        return map;
    }

    /**
     * 未登录
     *
     * @Author youcong
     */
    @RequestMapping("/unauth")
    public Map<String, Object> unauth() {
        Map<String, Object> map = new HashMap<>();
        map.put("code", 500);
        map.put("msg", "未登录");
        return map;
    }

    @PostMapping("/list")
    @RequiresRoles("1")
    public String list() {

        System.out.println("list:" + redisTemplate.opsForValue().get("list"));
        if (StringUtils.isEmpty(redisTemplate.opsForValue().get("list"))) {
            redisTemplate.opsForValue().set("list", usersService.list(), 360, TimeUnit.MINUTES);
        }
        return redisTemplate.opsForValue().get("list").toString();

    }


}
