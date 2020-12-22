package com.qtrue.mapper;

import com.qtrue.entity.Training_User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Package: com.qtrue.mapper
 * @ClassName: Training_UserMapper
 * @Author: xiaoBao
 * @CreateTime: 2020-12-22 9:32
 * @Description:【实习学生信息表持久层】
 */

/**@Mapper注解：定义此注解的功能在于能够让SpringBoot的主程序入口类中的@MapperScan能够找到该接口*/
@Mapper
public interface Training_UserMapper {
    /** 查询所有学生信息*/
    @Select("select * from training_user")
    List<Training_User> findUserInfo();
}
