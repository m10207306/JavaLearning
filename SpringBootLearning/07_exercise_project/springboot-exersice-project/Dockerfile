# 使用官方的 OpenJDK 基礎映像
FROM openjdk:17

# 設定工作目錄
WORKDIR /app

# 將 JAR 文件複製到容器中的 /app 目錄
COPY target/springboot-exersice-project-0.0.1-SNAPSHOT.jar /app/app.jar

# 暴露應用的端口
EXPOSE 8080

# 設定容器啟動時執行的命令
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
