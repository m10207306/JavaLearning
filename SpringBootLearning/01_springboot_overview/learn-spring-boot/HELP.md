# Read Me First

The following was discovered as part of building this project:

- The original package name 'com.in28minutes.springboot.learn-spring-boot' is invalid and this project uses 'com.in28minutes.springboot.learn_spring_boot' instead.

# Getting Started

### Reference Documentation

For further reference, please consider the following sections:

- [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
- [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.3.1/maven-plugin/reference/html/)
- [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.3.1/maven-plugin/reference/html/#build-image)
- [Spring Web](https://docs.spring.io/spring-boot/docs/3.3.1/reference/htmlsingle/index.html#web)

### Guides

The following guides illustrate how to use some features concretely:

- [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
- [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
- [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

### Maven Parent overrides

Due to Maven's design, elements are inherited from the parent POM to the project POM.
While most of the inheritance is fine, it also inherits unwanted elements like `<license>` and `<developers>` from the parent.
To prevent this, the project POM contains empty overrides for these elements.
If you manually switch to a different parent and actually want the inheritance, you need to remove those overrides.

# 筆記

1. Spring Boot Starter Projects

   1. 很方便的載入你要做的 Application 所需的 Framework, 可看 pom.xml, 也可以 dependency 使用 alt 按下去看細節
   2. 例如 Web Application & Rest API: Spring Boot Starter Web
   3. Unit Tests: Spring Boot Starter Test
   4. Talk to database using JPA: Spring Boot Starter Data JPA
   5. Talk to database using JDBC: Spring Boot Starter JDBC
   6. [問題] 事後如果要追加要怎麼做？

2. Auto Configuration

   1. 在 src/main/resources/application.properties 下面設定 logging.level.org.springframework=debug 可以把 log 改成 debug 等級
   2. Configuration 都存在於 Maven Dependencies 下的 jar
   3. [問題] 不太懂這個意義

3. Spring Boot DevTools

   1. 在 pom.xml 中加入 spring-boot-devtools 的 dependency 就可以不用每次改 code 之後重新手動啟動程式
   2. 在 pom.xml 中做任何更動都需要手動重啟, devtools 沒辦法自動幫你處理

4. Profiles

   1. 不同環境的不同 configuration
   2. 創建不同環境的 application.properties, 例如 application-dev.properties
   3. 然後要在 application.properties 設定 spring.profiles.active=dev 去決定啟用的 properties

5. Configuration Properties

   1. 可以創建一個 class 設定成 @ConfigurationProperties
   2. 接著 application.properties 就可以 assign 上面 class 的 properties
   3. 重點是讀取外部的 properties 放入 bean 當中

6. Actuator

   1. 看起來是可以 monitor 系統狀態的功能
   2. 在 pom.xml 中 dependency 加入 spring-boot-actuator
   3. 就可以到 localhost:8080/actuator 看到他所提供的 endpoint
   4. 如果想要開放 Actuator 更多端點, 需要到 application.properties 新增 management.endpoints.web.exposure.include=\*
   5. beans: 顯示所有已加載的 spring bean
   6. configprops: 可以看到所有藉由 application properties 設定的 config
   7. env: 顯示所有環境設定
   8. metrics: 裡面記錄一些可以查看的指標的 endpoint
   9. 如果開放比較多端點也代表會佔用更多的 RAM 與 CPU
   10. 因此通常會指定具體要開放的端點, 語法類似: management.endpoints.web.exposure.include=health,metrics

7. Spring Boot vs Spring MVC vs Spring Framework

   1. Spring Framework: Dependency injection

      1. @Component, @Autowired, Component scan, ...
      2. Spring Modules and Spring Projects extends Spring Eco System: Hibernete/JPA, JUnit/Mockito, ...

   2. Spring MVC (Spring Module): Simplify building web apps and REST API

      1. @Controller, @RestController, @RequestMapping("/courses")

   3. Spring Boot (Spring Project): 整合包裝 Spring and Spring MVC

      1. Starter Projects
      2. Auto Configuration: 減少設定
      3. Non functional requirements (NFRs)
         1. Actuator
         2. Embedded Server
         3. Logging and Error handling
         4. Profiles and ConfigurationProperties

8.
