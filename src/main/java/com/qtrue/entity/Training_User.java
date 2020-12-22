package com.qtrue.entity;

import java.io.Serializable;

/**
 * @Package: com.my.sign.entity
 * @ClassName: Training_User
 * @Author: xiaoBao
 * @CreateTime: 2020/12/20 16:35
 * @Description:【用户Cookie数据实体】：包含学生账号信息，云学习平台功能操作数据等。
 */
public class Training_User implements Serializable {
    // 学生账号 （学号）
    private String account;
    // 学生密码 （使用32位小写Md5加密）
    private String apassword;
    // 账号类型 （学生账号默认为2，其他未知；）
    private String atype;

    // 登录学生的luid（登录时获得，一直有效不变的，签到请求等需要用到）
    private String luid;
    // 登录学生的token（登录时获得，服务器随机生成的SessionId； 例如发送签到或日志请求需要传输该值）
    private String ltoken;
    // 签到地点 （URLEncoder编码）
    private String address;

    /** 生成Get/Set方法*/
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getApassword() {
        return apassword;
    }

    public void setApassword(String apassword) {
        this.apassword = apassword;
    }

    public String getAtype() {
        return atype;
    }

    public void setAtype(String atype) {
        this.atype = atype;
    }

    public String getLuid() {
        return luid;
    }

    public void setLuid(String luid) {
        this.luid = luid;
    }

    public String getLtoken() {
        return ltoken;
    }

    public void setLtoken(String ltoken) {
        this.ltoken = ltoken;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
