package com.blog.tutorial07.shiro.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blog.tutorial07.shiro.dto.UserParamRespDTO;
import com.blog.tutorial07.shiro.entity.Usermeta;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
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
public interface UsermetaDao extends BaseMapper<Usermeta> {

    @Select({"<script>",
            "select distinct meta_key,meta_value from wp_usermeta",
            "where user_id = #{userId}",
            "</script>"})
    @Results({
            @Result(column = "meta_key", property = "metaKey"),
            @Result(column = "meta_value", property = "metaValue")
    })
    List<UserParamRespDTO> selectAllInfoList(@Param("userId") Long userId);


    @Select({"<script>",
            "SELECT IFNULL(COUNT(meta_value),0) FROM wp_usermeta WHERE meta_key = 'wp_user_level' AND meta_value = #{metaValue}",
            "</script>"})
    Integer selectRoleCount(@Param("metaValue") String metaValue);
}
