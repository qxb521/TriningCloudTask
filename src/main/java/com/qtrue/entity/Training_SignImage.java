package com.qtrue.entity;

import java.io.Serializable;

/**
 * @Package: com.my.sign.entity
 * @ClassName: Training_SignImage
 * @Author: xiaoBao
 * @CreateTime: 2020-12-22 8:34
 * @Description:【图片Base64编码实体类】：用于对应数据库的training_signimage图片表。
 */
public class Training_SignImage implements Serializable {
    // 图片Id
    private Integer aid;
    // Base64编码
    private String acontent;

    /** 生成Get/Set方法*/
    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getAcontent() {
        return acontent;
    }

    public void setAcontent(String acontent) {
        this.acontent = acontent;
    }
}
