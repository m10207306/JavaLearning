package com.springboot.exercise.springboot_exersice_project.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "config") // 當如果要撈大量的application properties時可以用這個
public class ConfigBean {
    // @Value("${config.env}")
    private String env;

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }
}
