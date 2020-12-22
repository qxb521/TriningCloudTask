package com.qtrue.service;

import com.qtrue.entity.Training_SignImage;
import com.qtrue.entity.Training_User;

import java.util.List;

/**
 * @Package: com.qtrue.service.imple
 * @ClassName: UserService
 * @Author: xiaoBao
 * @CreateTime: 2020-12-22 9:12
 * @Description:【实习学生信息业务层接口】:查询所有学生信息和图像信息
 */
public interface UserService {
    /** 查询所有学生账号信息*/
    List<Training_User> findUserInfo();

    /** 查询所有图片Base64编码*/
    List<Training_SignImage> findAllImageBase64();
}
