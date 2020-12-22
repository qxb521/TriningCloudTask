package com.qtrue.utils;

import com.qtrue.entity.Training_User;

/**
 * @Package: com.my.sign.utils
 * @ClassName: UserData
 * @Author: xiaoBao
 * @CreateTime: 2020/12/20 20:47
 * @Description:【用户登录信息类】（测试用）
 */
public class UserData {

    public static Training_User getUserInfo(){

        Training_User userInfo = new Training_User();
        userInfo.setAccount("");
        userInfo.setApassword(encryptionUtil.getMD5String(""));
        userInfo.setAtype("2");

        return userInfo;
    }

}
