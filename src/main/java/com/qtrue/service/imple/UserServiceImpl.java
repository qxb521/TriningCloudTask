package com.qtrue.service.imple;

import com.qtrue.entity.Training_SignImage;
import com.qtrue.entity.Training_User;
import com.qtrue.mapper.TrainingSignImageMapper;
import com.qtrue.mapper.Training_UserMapper;
import com.qtrue.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Package: com.qtrue.service.imple
 * @ClassName: UserServiceImpl
 * @Author: xiaoBao
 * @CreateTime: 2020-12-22 9:13
 * @Description:【学生信息业务层接口实现类】
 */
/** 声明业务层*/
@Service("userServiceImpl")
public class UserServiceImpl implements UserService {
    /** 引入持久层Mapper动态接口*/
    @Resource
    private Training_UserMapper userMapper;
    @Resource
    private TrainingSignImageMapper signImageMapper;


    /**
     * findUserInfo 查询所有学生账号信息
     * @return 将所有账号信息返回给表现层
     */
    @Override
    public List<Training_User> findUserInfo() {
        return userMapper.findUserInfo();
    }

    /**
     * findAllImageBase64 查询所有图片Base64编码
     * @return 将所有图片信息返回给表现层，通过下标随机抽取任意一个图片信息用于签到
     */
    public List<Training_SignImage> findAllImageBase64(){
        return signImageMapper.findAllImageBase64();
    }
}
