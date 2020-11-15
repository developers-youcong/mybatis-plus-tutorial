package com.blog.tutorial07.shiro.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author youcong
 * @since 2020-04-18
 */
@TableName("wp_usermeta")
public class Usermeta extends Model<Usermeta> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "umeta_id", type = IdType.AUTO)
    private Long umetaId;
    @TableField("user_id")
    private Long userId;
    @TableField("meta_key")
    private String metaKey;
    @TableField("meta_value")
    private String metaValue;


    public Long getUmetaId() {
        return umetaId;
    }

    public void setUmetaId(Long umetaId) {
        this.umetaId = umetaId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getMetaKey() {
        return metaKey;
    }

    public void setMetaKey(String metaKey) {
        this.metaKey = metaKey;
    }

    public String getMetaValue() {
        return metaValue;
    }

    public void setMetaValue(String metaValue) {
        this.metaValue = metaValue;
    }

    @Override
    protected Serializable pkVal() {
        return this.umetaId;
    }

    @Override
    public String toString() {
        return "Usermeta{" +
        "umetaId=" + umetaId +
        ", userId=" + userId +
        ", metaKey=" + metaKey +
        ", metaValue=" + metaValue +
        "}";
    }
}
