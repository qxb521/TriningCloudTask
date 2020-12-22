package com.qtrue.app;

import com.alibaba.fastjson.JSON;
import com.qtrue.YunxuexiApplication;
import com.qtrue.entity.Training_SignImage;
import com.qtrue.entity.Training_User;
import com.qtrue.service.UserService;
import com.qtrue.utils.Request;
import com.qtrue.utils.UserData;
import com.qtrue.utils.encryptionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

/**
 * @Package: com.qtrue.app
 * @ClassName: SignTaskRun
 * @Author: xiaoBao
 * @CreateTime: 2020-12-22 9:47
 * @Description:【签到程序开始的地方】：调用业务层逻辑、Http请求封装工具类、编码加密类等执行签到程序
 */

/** @Component注解：将启动类的生命周期交给Spring容器进行管理，以便于在其他地方通过@Resource注解引入，并调用其中的方法；*/
@Component
public class SignTaskRun {
    /** 引入业务层*/
    @Resource(name = "userServiceImpl")
    private UserService userService;

    /** 生成该类的一个静态对象用于在start方法中能够正常调用类中的方法和引入的业务层*/
    public static SignTaskRun signTaskRun;
    /** @PostConstruct注解：被@PostConstruct修饰的方法会在服务器加载Servlet的时候运行，并且只会被服务器执行一次。
     *      总结：
     *          1、PostConstruct在构造函数之后执行，init（）方法之前执行。
     *          2、只有一个方法可以使用此注释进行注解；
     *          3、被注解方法不得有任何参数；
     *          4、被注解方法返回值为void；
     *          5、此方法只会被执行一次；
     *          6、被注解方法需是非静态方法。
     */
    @PostConstruct
    public void init() {
        //特指当前类的对象，当程序启动时将返回给上方定义的静态对象（以便于在其他方法中能够正常调用类中的方法和属性）
        signTaskRun = this;
    }


    /** 开始调用签到程序的方法*/
    public StringBuilder start(){
        // 实例化一个StringBuilder对象用于保存签到结果
        StringBuilder str=new StringBuilder();

        /** 调用业务层逻辑：查询所有学生信息*/
        List<Training_User> userList = signTaskRun.userService.findUserInfo();
        /** foreach遍历集合中的每一个对象，有多少个对象程序就会执行多少次*/
        for (Training_User user: userList) {
            String result = signRun(user);
            str.append(result).append("\n\n").append("-----------------------------------------\n\n");
        }

        // 最后返回执行结果
        return str;
    }

    /**
     * signRun 【学生自动签到主程序】
     * @param user 学生账号信息—来自于本地服务器数据库（通过调用业务层、持久层查询）
     * @return 将自动签到程序执行的结果返回给调用主程序的方法；
     */
    public String signRun(Training_User user){
        /** 获取日志记录器对象 */
        Logger logger = LoggerFactory.getLogger(YunxuexiApplication.class);

        // 登录
        String LOGIN_URL = "http://sx.lcvc.cn//mobile/common/login.xhtml";
        // 点击实习事件获取uid
        String PRACTICE_URL = "http://sx.lcvc.cn//mobile/training/s_practice.xhtml";
        // 签到
        String SIGN_URL = "http://sx.lcvc.cn//mobile/training/s_practice_qd.xhtml";


        /** 调用业务层逻辑：查询所有图像信息*/
        List<Training_SignImage> imageList = signTaskRun.userService.findAllImageBase64();
        // 随机获取集合中的一张图像Base64编码
        Training_SignImage image = imageList.get(encryptionUtil.getRandom(1,imageList.size()));

        // 账号信息
        String account = user.getAccount();
        String apassword = encryptionUtil.getMD5String(user.getApassword());
        String atype = user.getAtype();
        String address = user.getAddress();
        // 签到图片（Base64编码）
        String acontent = image.getAcontent();


        /** 发送登录Post请求—传递四个参数：URL、账号、密码、账号类型*/
        String loginResult = Request.sendLoginPost(
                LOGIN_URL,
                account,
                apassword,
                atype
        );
        logger.info(loginResult);
        // 实时获取登录成功后服务器响应的JSON数据，并解析成需要的对象;
        user = JSON.parseObject(loginResult, Training_User.class);
        /** 将登录成功后的uid和token赋值给变量*/
        String uid = user.getLuid();
        String token = user.getLtoken();



        /** 发送点击实习实践Post请求获取pid—传递三个参数：URL、账号uid、token*/
        String practiceResult = Request.sendPracticePost(
                PRACTICE_URL,
                uid,
                token
        );
        // 截取点击实践任务后服务器响应的JSON数据中的uid—用于签到
        String pid = practiceResult.substring(7, 10);



        /** 发送签到Post请求—传递9个参数：URL、用户信息等、签到action(qdadd)、经纬度、编码后的地址和Base64图像*/
        String signResult = Request.sendSignPost(
                SIGN_URL,
                pid,
                uid,
                token,
                "qdadd",
                encryptionUtil.getURLDecoder(address),
                encryptionUtil.getRandom(0,9),
                encryptionUtil.getRandom(0,9),
                encryptionUtil.getURLDecoder(acontent)
        );
        logger.info(signResult);

        /** 判断执行结果是否成功*/
        if (signResult.toString().equals("1")){
            return "学号："+account+"签到成功~！";
        }else {
            return "学号："+account+"签到失败！";
        }
    }

}
