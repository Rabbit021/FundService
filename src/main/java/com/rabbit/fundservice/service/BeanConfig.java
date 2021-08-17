package com.rabbit.fundservice.service;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.var;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import java.time.Duration;

/**
 * 常用的配置类
 */
@Configuration
public class BeanConfig {
    @Bean
    public ObjectMapper getObjectMapper() {
        var instance = new ObjectMapper();
        instance.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        instance.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
        return instance;
    }

    @Bean
    public RestTemplate getRestTemplate(RestTemplateBuilder builder) {
        RestTemplate restTemplate = builder
                .setConnectTimeout(Duration.ofMillis(3000))
                .setReadTimeout(Duration.ofMillis(3000))
                .build();
        return restTemplate;
    }
}
