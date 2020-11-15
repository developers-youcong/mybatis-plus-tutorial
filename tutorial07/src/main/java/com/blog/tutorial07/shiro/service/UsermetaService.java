package com.blog.tutorial07.shiro.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.blog.tutorial07.shiro.entity.Usermeta;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author youcong
 * @since 2020-04-18
 */
public interface UsermetaService extends IService<Usermeta> {


    Map<String, String> queryUserParamListInfo(Long userId);
}
