package com.qtrue;

/**
 * @Package: com.qtrue
 * @ClassName: YunxuexiApplication
 * @Author: xiaoBao
 * @CreateTime: 2020-12-22 9:50
 * @Description:【SpringBoot云学习助理实习平台项目程序主入口类】
 */

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/** @SpringBootApplication：注解入口类，表明该类为SpringBoot的主配置类*/
@SpringBootApplication
/** @EnableScheduling注解：SpringBoot定时任务（该注解需要一个设置了执行哪个类或方法的定时任务类）*/
@EnableScheduling
/** @MapperScan注解：用于配置持久层Mapper的全限定包名（仅在多模块的项目架构下需要配置全限定包名）*/
@MapperScan
public class YunxuexiApplication {

    public static void main(String[] args) {
        /**
         * SpringApplication.run()方法：启动SpringBoot；
         * 需要通过main方法来使用此方法启动SpirngBoot应用
         */
        SpringApplication.run(YunxuexiApplication.class,args);
    }

}
