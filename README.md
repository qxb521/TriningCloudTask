# 云实习平台自动签到程序

## 项目的介绍
  * 起初开发这个程序的原因是最近处于实习期间，学校要求实习的学生每天都要在一个APP上完成每日签到的任务，所以决定用Java语言写一个自动签到的程序。
  * 项目的架构是基于SSM框架的三层架构（表现层、业务层、持久层）完成的；
  * 项目使用的框架是：SpringBoot整合Mybatis；
  * 项目使用的数据库：MySQL；
  * 项目使用到的技术：抓包(核心)、云服务器、SpringBoot定时任务、微信消息推送、数据加密、URL编码等（详情见代码内注释）；
  
## 使用说明
  * 首先得拥有一个Linux的CentOS7.3以上系统的服务器（本程序使用的是阿里云轻量应用服务器）；
  * 在服务器部署宝塔面板https://www.bt.cn/bbs/thread-19376-1-1.html
  * 项目内配置定时任务(cron表达式)、服务器数据库连接参数(本程序使用的是阿里druid连接池)、项目端口、Server酱推送API；
  * SpringBoot项目打包：使用Maven插件—Lifecycle—clean—install依次运行，然后在项目目录中生成Target文件(jar包就在这里)；
  * 将需要签到的学生账号全部以此加入到服务器上的数据库中(可以现在本地写好然后转储SQL文件，在宝塔面板上传SQL即可)；
  * 宝塔上的软件商店内安装“JAVA项目一键部署”、Tomcat8(自动安装JDK8环境到服务器)；
  * 完成以上步骤后使用“JAVA项目一键部署”应用——点击SpringBoot项目，上传jar包文件(上传后默认一直运行)。
  

### 如有建议请联系微信：15723889613 新手开发不喜勿喷，喜欢的话给个Star吧，谢谢~！
