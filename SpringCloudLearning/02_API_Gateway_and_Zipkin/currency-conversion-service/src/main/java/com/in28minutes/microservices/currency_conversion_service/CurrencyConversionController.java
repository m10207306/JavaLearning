package com.in28minutes.microservices.currency_conversion_service;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Configuration(proxyBeanMethods = false)
class RestTemplateConfiguration {

    @Bean
    RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}

@RestController
public class CurrencyConversionController {

    @Autowired
    private CurrencyExchangeProxy proxy;

    @Autowired
    private RestTemplate restTemplate;  // 為了讓 Zipkin 可以追蹤使用 RestTemplate 調用的服務

    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculateCurrencyConversion(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
        // 這裡的程式太繁複, 因此有 Feign
        HashMap<String, String> uriVariables = new HashMap<>();
        uriVariables.put("from", from);
        uriVariables.put("to", to);

        ResponseEntity<CurrencyConversion> responseEntity = restTemplate.getForEntity(
                                                                "http://localhost:8000/currency-exchange/from/{from}/to/{to}", 
                                                                CurrencyConversion.class, 
                                                                uriVariables);
        // ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate().getForEntity(
        //                                                         "http://localhost:8000/currency-exchange/from/{from}/to/{to}", 
        //                                                         CurrencyConversion.class, 
        //                                                         uriVariables);

        CurrencyConversion currencyConversion = responseEntity.getBody();

        return new CurrencyConversion(
                            currencyConversion.getId(), 
                            from, 
                            to, 
                            currencyConversion.getConversionMultiple(), 
                            quantity, 
                            quantity.multiply(currencyConversion.getConversionMultiple()), 
                            currencyConversion.getEnvironment() + " rest template");
    }

    @GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculateCurrencyConversionFeign(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
        // Feign 版本
        CurrencyConversion currencyConversion = proxy.retrieveExchangeValue(from, to);
        return new CurrencyConversion(
                            currencyConversion.getId(), 
                            from, 
                            to, 
                            currencyConversion.getConversionMultiple(), 
                            quantity, 
                            quantity.multiply(currencyConversion.getConversionMultiple()), 
                            currencyConversion.getEnvironment() + " feign");
    }
}
