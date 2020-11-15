package com.blog.tutorial07.shiro.dto;

import java.io.Serializable;

public class UserParamRespDTO implements Serializable {


    private String metaKey;

    private String metaValue;

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
}
