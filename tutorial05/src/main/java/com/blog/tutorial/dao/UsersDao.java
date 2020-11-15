package com.blog.tutorial.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blog.tutorial.entity.Users;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author youcong
 * @since 2020-04-18
 */
@Repository
public interface UsersDao extends BaseMapper<Users> {

    IPage<Users> selectPageVo(Page<Users> page);

}
