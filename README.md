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
      1. 導入 springdoc-openapi-starter-webmvc-ui 就可以自動產生 swagger 頁面
   8. Content Negotiation
      1. 同樣的 Resource 根據 consumer 的 accept header 提供 json/xml
      2. 用 accept-language 提供 中文/英文/日文 (messages.properties 檔名是固定的)
   9. Internationalization
      1. messageSource.getMessage()
   10. URI Versioning
       1. URL Versioning
          1. /v1/person, /v2/person
       2. Request Parameter Versioning
          1. /person?version=1, /person?version=2
       3. Header Versioning
          1. header: X-API-VERSION=1, X-API-VERSION=2
       4. Media type versioning
          1. header: accept=application/vnd.company.app-v1+json
   11. HATEOAS
   12. Filter response json
   13. Actuator
   14. HAL Explorer
   15. JPA
       1. JDBC -> Spring JDBC -> Hibernate -> JPA -> Spring Data JPA
       2. Spring Data JPA 看起來很簡單，但是如果情境複雜該怎麼辦？
       3. 看起來會自動創建 table，公司內實務上應該是要先由 DBA 創建 table 嗎？
       4. 放在 resources 的 sql 都會被自動執行嗎？ (只認 data import schema 三個檔名, 有各自用途)
   16. Authentication
