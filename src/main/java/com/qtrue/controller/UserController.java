package com.qtrue.controller;

import com.qtrue.app.SignTaskRun;
import com.qtrue.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;

/**
 * @Package: com.qtrue.controller
 * @ClassName: UserController
 * @Author: xiaoBao
 * @CreateTime: 2020-12-22 9:16
 * @Description:【实习学生相关功能表现层】：该表现层仅用于测试，实际运行程序开发完成后忽略此类；
 */

/** @Component注解：将表现层的生命周期交给Spring容器进行管理，以便于在其他地方通过@Resource注解引入，并调用其中的方法；*/
@Component
public class UserController {
    /** 引入业务层*/
    @Resource(name = "userServiceImpl")
    private UserService userService;


    /**
     * execute 签到开始
     */
    @RequestMapping("TrainingSign")
    public String execute(){
        StringBuilder startResult = new SignTaskRun().start();
        return startResult.toString();
    }

}
