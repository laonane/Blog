# Blog 
描述：基于 SSH 框架 + 前后端分离的博客项目

> author: laona


## 初始化项目
### 项目配置
- 导入相应的 jar 包到 [WEB-INF/lib](./web/WEB-INF/lib)

- 把配置文件放到 resource 中

> - Spring 配置文件：[applicationContext.xml](./resource/applicationContext.xml)
> - Hibernate 配置文件：[hibernateApplicationContext.xml](./resource/hibernateApplicationContext.xml)
> - MySQL 配置文件：[jdbc.properties](./resource/jdbc.properties)
> - Log4J 配置文件：[log4j2.xml](./resource/log4j2.xml)
> - Struts 配置文件：[struts.xml](./resource/struts.xml)


## 访问页面

### index.jsp 为博客文章欢迎页
### mgr_login.jsp 为后台管理页面

- 注：数据库存储密码为明文

账号：laona
密码：123

## FEATURE

**打算搭建 2.0 版本，使用 springboot 构建。** 

- 2022年1月9日

已经添加 [dev分支](https://github.com/HuaiAnGG/Blog/tree/dev)  支持Springboot（功能待实现）