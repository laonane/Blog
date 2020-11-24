# Blog 
描述：基于 SSH 框架 + 前后端分离的博客项目

## 初始化项目
### 项目配置
- 导入相应的 jar 包到 [WEB-INF/lib](./web/WEB-INF/lib)

> - antlr-2.7.7.jar
> - asm-7.3.1.jar
> - asm-commons-7.3.1.jar
> - asm-tree-7.3.1.jar
> - byte-buddy-1.8.12.jar
> - classmate-1.3.4.jar
> - com.springsource.com.mchange.v2.c3p0-0.9.1.2.jar
> - com.springsource.org.aopalliance-1.0.0.jar
> - com.springsource.org.apache.commons.dbcp-1.2.2.osgi.jar
> - com.springsource.org.apache.commons.logging-1.1.1.jar
> - com.springsource.org.apache.commons.pool-1.5.3.jar
> - com.springsource.org.apache.log4j-1.2.15.jar
> - com.springsource.org.aspectj.weaver-1.6.8.RELEASE.jar
> - commons-beanutils-1.8.3.jar
> - commons-fileupload-1.4.jar
> - commons-io-2.6.jar
> - commons-lang3-3.8.1.jar
> - dom4j-1.6.1.jar
> - druid-1.0.15.jar
> - freemarker-2.3.30.jar
> - hamcrest-all-1.3.jar
> - hamcrest-core-1.3.jar
> - hibernate-c3p0-5.3.1.Final.jar
> - hibernate-commons-annotations-5.0.3.Final.jar
> - hibernate-core-5.3.1.Final.jar
> - jandex-2.0.3.Final.jar
> - javassist-3.22.0-GA.jar
> - javax.persistence-api-2.2.jar
> - jboss-logging-3.3.2.Final.jar
> - jboss-transaction-api_1.2_spec-1.1.1.Final.jar
> - junit-4.13.jar
> - log4j-api-2.12.1.jar
> - log4j-core-2.12.1.jar
> - mchange-commons-java-0.2.11.jar
> - mysql-connector-java-8.0.16.jar
> - ognl-3.1.28.jar
> - spring-aop-5.0.7.RELEASE.jar
> - spring-aspects-5.0.7.RELEASE.jar
> - spring-beans-5.0.7.RELEASE.jar
> - spring-context-5.0.7.RELEASE.jar
> - spring-core-5.0.7.RELEASE.jar
> - spring-expression-5.0.7.RELEASE.jar
> - spring-jdbc-5.0.7.RELEASE.jar
> - spring-orm-5.0.7.RELEASE.jar
> - spring-test-5.0.7.RELEASE.jar
> - spring-tx-5.0.7.RELEASE.jar
> - spring-web-5.0.7.RELEASE.jar
> - struts2-core-2.5.25.jar
> - struts2-spring-plugin-2.5.16.jar

- 把配置文件放到 resource 中

> - Spring 配置文件：[applicationContext.xml](./resource/applicationContext.xml)
> - Hibernate 配置文件：[hibernateApplicationContext.xml](./resource/hibernateApplicationContext.xml)
> - MySQL 配置文件：[jdbc.properties](./resource/jdbc.properties)
> - Log4J 配置文件：[log4j2.xml](./resource/log4j2.xml)
> - Struts 配置文件：[struts.xml](./resource/struts.xml)



