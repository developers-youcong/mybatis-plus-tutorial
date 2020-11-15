package com.blog.tutorial07.shiro.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.tutorial07.shiro.dao.UsermetaDao;
import com.blog.tutorial07.shiro.dto.UserParamRespDTO;
import com.blog.tutorial07.shiro.entity.Usermeta;
import com.blog.tutorial07.shiro.service.UsermetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author youcong
 * @since 2020-04-18
 */
@Service
public class UsermetaServiceImpl extends ServiceImpl<UsermetaDao, Usermeta> implements UsermetaService {

    @Autowired
    private UsermetaDao usermetaDao;


    @Override
    public Map<String, String> queryUserParamListInfo(Long userId) {


        Map<String, String> returnMap = new HashMap<String, String>();

        List<UserParamRespDTO> userParamRespDTOS = usermetaDao.selectAllInfoList(userId);

        if (!userParamRespDTOS.isEmpty()) {

            for (UserParamRespDTO u : userParamRespDTOS) {

                returnMap.put(u.getMetaKey(), u.getMetaValue());
            }
        }

        return returnMap;
    }
}
