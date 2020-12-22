package com.qtrue.mapper;

import com.qtrue.entity.Training_SignImage;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Package: com.qtrue.mapper
 * @ClassName: TrainingSignImageMapper
 * @Author: xiaoBao
 * @CreateTime: 2020-12-22 9:07
 * @Description:【学生实习签到图像信息表持久层】
 */

/**@Mapper注解：定义此注解的功能在于能够让SpringBoot的主程序入口类中的@MapperScan能够找到该接口*/
@Mapper
public interface TrainingSignImageMapper {
    /** 查询所有图片Base64编码*/
    @Select("select * from training_signimage")
    List<Training_SignImage> findAllImageBase64();
}
