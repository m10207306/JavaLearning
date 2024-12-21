package com.in28minutes.microservices.currency_exchange_service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircuitBreakerController {

    private Logger logger  = LoggerFactory.getLogger(CircuitBreakerController.class);

    @GetMapping("/sample-api")
    // @Retry(name = "default") // 失敗三次之後才回傳
    // @Retry(name = "retry-name")
    // @Retry(name = "retry-name", fallbackMethod = "hardcodedResponse") // 客製化的 fallback 方法
    // @CircuitBreaker(name = "circuit-breaker-name", fallbackMethod = "hardcodedResponse")
    // @RateLimiter(name = "ratelimiter-name")
    @Bulkhead(name = "bulkhead-name")
    public String sampleApi() {
        // Retry & CircuitBreaker 測試
        // String response = new RestTemplate().getForObject("http://localhost:8080/some-dummy-url", String.class);
        // return response;

        // RateLimiter測試
        logger.info("Sample Api call received");
        return "sample-api";
    }

    public String hardcodedResponse(Exception ex) {
        return "fallback-response";
    }
}
