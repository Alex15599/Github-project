![foxnic](platform/view/view-console/src/main/resources/static/assets/images/foxnic-250.jpg)

# Foxnic-EAM 资产管理系统介绍
- 实现企业对资产的基本管理,包含对资产的登记、维修、调拨、转移等基本功能的支持，并提供对资产的耗材、库存进行管理，有完善的组织架构，非常适合中小企业的需求
- EAM系统整体覆盖了基本的资产管理、合同管理、运维服务、运维服务、数据中心设备管理等多个模块。

# Foxnic-EAM 项目构建说明
- 当前托管的Foxnic-EAM源代码已包含所有的涉及EAM的源代码，数据库表结果也已发布，整个项目构建需要一定的开发经验。

# 系统及相关文档下载地址
- 链接: https://pan.baidu.com/s/1d6Yvszugq2fdGNEsW8ijmQ 提取码: lm6i
- <img width="200"  src="https://images.gitee.com/uploads/images/2022/0621/084431_f977a14d_448530.png" />

### 官方网站
- http://web.foxnicweb.com/
- 1、QQ群:634770774
- 2、微信号:myxyjm
- 企业或个人相关技术开发合作，请进群联系我们！
- 微信群：      
  ![微信群](platform/view/view-console/src/main/resources/static/assets/images/wx.png)


### 系统DEMO
- [Demo] 每天定时由阿里云效自动编译发布部署
- [Demo] PC端:http://eam-demo.rainbooow.com:8089/index.html
- [Demo] PC端:https://eam-demo.rainbooow.com:8090/index.html
- [Demo] 移动端H5版:https://eam-demo.rainbooow.com:8091
- [Demo] 移动端APP内置自行下载
- [Demo] 超级管理员账户:admin 密码:123456  其它账户密码 为 fx9090
- [Demo] 固定资产管理员(账户):eamadmin 密码:fx9090
- [Demo] 固定资产普通员工(账户):eamuser 密码:fx9090
- [Demo] 流程测试账号,统一密码 fx9090
- ----------------------------------------------------------------- 
- [Demo]-------------Foxnic-EAM 资产管理账户-------------
- [Demo]管理员:eamadmin fx9090
- [Demo]员工1:eamuser1 fx9090
- [Demo]员工2:eamuser2 fx9090
- [Demo]查询:eamquery fx9090
  

- [Demo]-------------Foxnic-KN 知识库账户-------------
- [Demo]管理员:knadmin fx9090
- [Demo]查询:knquery fx9090
 
-
- [Demo]-------------Foxnic-OPS 运维账户-------------
- [Demo]管理员:opsadmin fx9090
- [Demo]查询:opsquery fx9090


- [Demo]-------------Foxnic-OPS-MONITOR 监控-------------
- [Demo]管理员:opsmonitoradmin fx9090
- [Demo]查询:opsmonitorquery fx9090


- [Demo]-------------Foxnic-Contract合同(开发中)-------------
- [Demo]管理员:contractadmin fx9090
- [Demo]查询:contractquery fx9090

| 类型 | 账户  | 姓名  |
|---|---|---|
| 流程管理员  |  k3 | 王军 |
| 流程测试员  | qiaof  | 乔峰  |
| 流程测试员  |wangjt|	汪剑通|
| 流程测试员  |mady|	马大元|
| 流程测试员  |xuanc|	玄慈|	
| 流程测试员  |xuz|	虚竹|			
| 流程测试员  |duanzc|	段正淳|		
| 流程测试员  |duany|	段誉|	
| 流程测试员  |duanyq|	段延庆|		
| 流程测试员  |nanhes|	南海鳄神|

#### 最新EAM编译后的包下载(为开发同步版本，并非发布版本)
- 1、存储过程:[下载SQL](http://foxnicweb.com/docs/chapters/base/1.1/NextVal.zip)
- 2、SQL文件:(每日更新):http://eam-demo.rainbooow.com/upload/sql.tar.gz   ( **必须使用 source 命令导入！！！** )

### 主要技术栈
#### 全栈技术体系符合信创技术要求
#### 后端技术栈
- 安全框架:Spring Security 5.3.4
- 开发框架:SpringBoot 2.3.3
- 数据库链接池:Druid 1.2.8
- 模版引擎:Thymeleaf 3
- 应用层框架:[Foxnic-Web](https://gitee.com/LeeFJ/foxnic-web) [开发文档](http://foxnicweb.com/docs/doc.html)
- 持久层框架:[FoxnicSQL&FoxnicDAO](https://gitee.com/LeeFJ/foxnic)
- 日志管理:Logback 1.2.3
- 流程引擎:Camunda
- 任务调度:Quartz 2.3.3
- 项目管理框架: Maven 3.6、3.8
- 运行容器:Undertow
#### 前端技术栈
- 前端组件:LayUI 2.6.8

#### 开发环境(特别注意，严格按照以下要求)
- 开发工具:IntelliJ IDEA 2020.2以上(不要使用eclipse)
- 数据库:Mysql 5.7.32(必须为Mysql5.7)
- Redis:5.0.12(可选)
- JDK:JDK 1.8.100 (小版本100以上,但仅支持1.8)

#### 系统架构图
![输入图片说明](https://images.gitee.com/uploads/images/2022/0407/143343_0a8f4947_448530.png "EAM.png")

#### 代码组织方式
![输入图片说明](https://foruda.gitee.com/images/1665182206427612624/9e7fcb5b_448530.png "WechatIMG68.png")

## EAM系统开源协议补充申明
- 1、EAM系统产品开源免费(协议:GPLv3)，并且将持续提供免费的社区技术支持，个人或企业内部可自由的接入和使用，但禁止任何单位或个人修改软件后再次发行或出售的行为
- 2、EAM系统源代码已开源，软件介质以社区版形式供免费使用,在未授权情况下，禁止修改涉及版权信息的相关代码和名称


## 二次开发说明
### 二次开发相关文档
- 1、本系统二次开发建议至少有1到2年JAVA开发经验
  开发前请确保了解系统二次开发说明、系统使用常见问题清单、系统使用手册等相关文档
- 2、问题清单或说明中已收录的问题，例如无法下载lib、启动报错CP、java版本不对在说明中已明确要求的不在做解答。

### 二次开发EAM系统部署的入门视频介绍(二次开发的环境部署)
- 1、配置EAM项目源码 https://www.bilibili.com/video/BV1844y1377V?spm_id_from=333.999.0.0
- 2、配置数据库 https://www.bilibili.com/video/BV1kR4y1P7Py?spm_id_from=333.999.0.0
- 3、配置与启动应用 https://www.bilibili.com/video/BV1wu411r7xC?spm_id_from=333.999.0.0
- 4、EAM部署 https://www.bilibili.com/video/BV1Q34y1a7LR?spm_id_from=333.999.0.0
- 5、EAM Maven设置 https://www.bilibili.com/video/BV1x34y1j7Ff?share_source=copy_web
- 6、EAM Maven依赖管理 https://www.bilibili.com/video/BV12T411K7pz/

### 二次开发相关的视频与文档集合
- 1、官网文档集合 http://foxnicweb.com/docs/doc.html
- 2、B站资料集合 https://space.bilibili.com/1796475412
- 3、知乎视频资料集合 https://www.zhihu.com/people/leefj/zvideos
- 4、知乎文档集合 https://www.zhihu.com/people/leefj/posts

### 二次开发示例项目
[Foxnic-Samples](https://gitee.com/LeeFJ/foxnic-samples)

## EAM系统安装部署
### 实施方案
- 1、传统方式:传统单体架构方式打包部署
- 2、微服务:拆分成独立微服务方式部署
- 3、集群模式:拆分成独立服务各自独立启动部署

### 软件介质
- 1、Docker部署:直接从docker拉镜像
- 2、应用直接运行部署:应用JAR和SQL包来源:https://gitee.com/lank/platform/releases


### EAM系统部署的视频介绍
- 1、待录制


### 方案一 一键安装Foxnic-EAM
- 自动安装Mysql,Java,EAM应用，Mysql从官方下载，因此整体安装速度会慢些
- 安装环境前先确认：
- 操作系统支持:RedHat 7.9 、RedHat 8.0、RedHat 8.2 较为干净的系统。yum源配置需正确(unzip,wget,zip等包需要安装)，公有云的默认yum配置一般没问题
- 数据库端口3306，密码root_pwd
- 访问地址为:http://ip:8089
- 安装目录:/app
```
#安装命令
curl -L 'http://resource.rainbooow.com/deploy.sh'|bash
```

### 方案二 应用直接部署
- 详细部署方式查询git目录下的文档说明
- 百度网盘地址，地址同上


## 系统演示预览
![输入图片说明](https://images.gitee.com/uploads/images/2021/1213/212929_46438369_448530.jpeg "1.jpg")
![输入图片说明](https://images.gitee.com/uploads/images/2022/0513/115529_b00ce19a_448530.png "WechatIMG3.png")
![输入图片说明](https://images.gitee.com/uploads/images/2021/1213/213230_1ba469f5_448530.png "屏幕截图.png")
![输入图片说明](https://images.gitee.com/uploads/images/2021/1213/213258_8d970535_448530.png "屏幕截图.png")
![输入图片说明](https://images.gitee.com/uploads/images/2021/1213/213315_83659719_448530.png "屏幕截图.png")
![输入图片说明](https://images.gitee.com/uploads/images/2022/0617/062632_fb854882_448530.png "WechatIMG1.png")
![输入图片说明](https://images.gitee.com/uploads/images/2022/0712/125124_788dfc2f_448530.jpeg "e1.jpg")
![输入图片说明](https://images.gitee.com/uploads/images/2022/0712/125138_061ee2e5_448530.jpeg "e2.jpg")
![输入图片说明](https://images.gitee.com/uploads/images/2022/0712/125147_e4425787_448530.jpeg "e3.jpg")
<img width="200"  src="https://images.gitee.com/uploads/images/2022/0619/223205_d0e22d76_448530.jpeg " />
<img width="200"  src="https://images.gitee.com/uploads/images/2022/0316/122751_e20f543f_448530.jpeg" />
<img width="200"  src="https://images.gitee.com/uploads/images/2022/0316/122759_2c4b10f6_448530.jpeg" />
<img width="200"  src="https://images.gitee.com/uploads/images/2022/0316/122807_a1c6116b_448530.jpeg" />
<img width="200"  src="https://images.gitee.com/uploads/images/2022/0316/122814_24bcd70e_448530.jpeg" />
<img width="200"  src="https://images.gitee.com/uploads/images/2022/0316/122824_f21ca8de_448530.jpeg" />
<img width="200"  src="https://images.gitee.com/uploads/images/2022/0326/212016_f9fa171e_448530.jpeg" />
<img width="200"  src="https://images.gitee.com/uploads/images/2022/0326/212025_135c19b0_448530.jpeg" />

## 捐赠
- 开源不易，坚持更难，如果您觉得本项目不错，可以捐赠请作者喝杯咖啡~，在此表示感谢^_^
- 同时欢迎EAM系统的商业化定制,也欢迎其他业务的开发合作。
- 捐赠(支付宝)
  <img width="200" height="200" src="https://images.gitee.com/uploads/images/2020/1105/135552_037eeb5c_448530.png" />

 
 