package com.in28minutes.rest.webservices.restful_web_services.security;

import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // 任何 request 都需要 authenticated
        http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());

        // 如果 request 未 authenticated, 跳出認證頁面
        http.httpBasic(withDefaults());

        // CSRF -> POST, PUT
        http.csrf().disable();

        return http.build();
    }

}
