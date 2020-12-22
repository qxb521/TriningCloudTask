package com.qtrue;

import com.qtrue.app.SignTaskRun;
import com.qtrue.utils.Request;
import com.qtrue.utils.encryptionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Package: com.qtrue
 * @ClassName: Scheduler
 * @Author: xiaoBao
 * @CreateTime: 2020-12-22 11:18
 * @Description:【定时任务配置类】：配置签到任务的执行时间
 */

/** @Component注解：表示将定时任务类的生命周期和对象交由Spring容器进行管理*/
@Component
public class Scheduler {
    /** 获取日志记录器对象 */
    Logger logger = LoggerFactory.getLogger(Scheduler.class);

    //实习签到
    /** @Scheduled注解：用于配置SpringBoot的定时任务（使用cron表达式）*/
    @Scheduled(cron = "0/60 * * * * ?")
    public void SignTaskRun(){
        // 执行签到程序并返回执行结果然后输出
        StringBuilder startResult = new SignTaskRun().start();

        /** 发送Server酱消息推送请求：将签到结果推送到微信*/
        if(startResult.toString()!=""){
            String content = startResult.toString();
            Request.sendSignResultToVx(content);
        }
    }

}
