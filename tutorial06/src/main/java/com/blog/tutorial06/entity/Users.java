package com.blog.tutorial06.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author youcong
 * @since 2020-04-18
 */
@Data
@TableName("wp_users")
public class Users extends Model<com.blog.tutorial.entity.Users> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;
    @TableField("user_login")
    private String userLogin;
    @TableField("user_pass")
    private String userPass;
    @TableField("user_nicename")
    private String userNicename;
    @TableField("user_email")
    private String userEmail;
    @TableField("user_url")
    private String userUrl;
    @TableField("user_registered")
    private Date userRegistered;
    @TableField("user_activation_key")
    private String userActivationKey;
    @TableField("user_status")
    private Integer userStatus;
    @TableField("display_name")
    private String displayName;


}
