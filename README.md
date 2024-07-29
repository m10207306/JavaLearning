# JavaLearning

1. 安裝 Java Development Kit (JDK)

   1. 安裝 JDK 17 對應 Java 17
   2. https://adoptium.net/temurin/releases/?os=mac&arch=x64&package=jdk&version=17

2. Spring Boot Introduction

   1. Spring Boot Magic:

      1. Spring Boot Starter Projects
         dependency 的描述符, 例如 spring-boot-starter-web, spring-boot-starter-data-jpa, spring-boot-starter-security, ...
      2. Auto Configuration
         把很多設定統一放在 application.properties
         還有很多設定都隨 dependency 自動載入, 例如 spring-boot-starter-web 自動配置 dispatcher servlet, embedded servlet container, bean <-> json
      3. DevTools
         程式異動後自動 reload 程式, 但是如果 dependency 異動還是要手動重啟
      4. Profiles
         不同環境對應不同的 config, 例如 application-dev.properties, application-uat.properties, ...
         再利用 application.properties 指定啟用的 config
      5. Configuration Properties
         讀取外部 properties 放入 bean 的 properties 中
      6. Actuator
         Monitor 當前系統的狀態

   2. Spring Boot vs. Spring MVC vs. Spring?

3. Spring Boot

   1. Get, Put, Post, Delete
   2. Path variable
   3. 指定 HTTP Status Code (UserResource.java 的 createUser)
   4. 處理 user 找不到時應該回傳 404 而非 500 的問題
      1. 創建自定義 Exception
   5. 自定義 Error Response Format
      1. 怎麼知道要去 override 哪一個 function? 還是 function 可以自己任意取名？
   6. Validation
      1. 把驗證錯誤的理由加入 response body
      2. 怎麼知道要 override handleMethodArgumentNotValid func?
   7. Swagger
      1.
   8. Internationalization
