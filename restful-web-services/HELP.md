# Read Me First

The following was discovered as part of building this project:

- The original package name 'com.in28minutes.rest.webservices.restful-web-services' is invalid and this project uses 'com.in28minutes.rest.webservices.restful_web_services' instead.

# Getting Started

### Reference Documentation

For further reference, please consider the following sections:

- [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
- [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.3.2/maven-plugin/reference/html/)
- [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.3.2/maven-plugin/reference/html/#build-image)
- [Spring Web](https://docs.spring.io/spring-boot/docs/3.3.2/reference/htmlsingle/index.html#web)
- [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.3.2/reference/htmlsingle/index.html#data.sql.jpa-and-spring-data)
- [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/3.3.2/reference/htmlsingle/index.html#using.devtools)

### Guides

The following guides illustrate how to use some features concretely:

- [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
- [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
- [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
- [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)

### Maven Parent overrides

Due to Maven's design, elements are inherited from the parent POM to the project POM.
While most of the inheritance is fine, it also inherits unwanted elements like `<license>` and `<developers>` from the parent.
To prevent this, the project POM contains empty overrides for these elements.
If you manually switch to a different parent and actually want the inheritance, you need to remove those overrides.

1. Request Methods for Restful API
   1. GET: 取得既有 resource
   2. POST: 新增 resource
   3. PUT: 更新既有 resource (整份) 或是 創建
   4. UPDATE: 更新既有 resource （整份）
   5. PATCH: 部分更新 resource
   6. DELETE: 刪除 resource
2. Response Status
   1. 404: 找不到資源
   2. 500: 伺服器內部錯誤
   3. 400: 驗證錯誤
   4. 200: 成功
   5. 201: Created
   6. 204: not content
   7. 401: Unauthorized
   8. 400: bad request
3. 取得所有 User: /users
   1. /users/{id}
   2. /users/{id}/name
