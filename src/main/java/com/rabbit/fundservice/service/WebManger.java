package com.rabbit.fundservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.swing.tree.VariableHeightLayoutCache;
import java.time.Duration;

/**
 * @author wangheng
 * web数据请求封装
 */
@Component
@Scope
public class WebManger {
    @Autowired
    RestTemplate restTemplate;

    public String getString(String url) {
        try {
            HttpEntity<String> entity = GetHeaders();
            ResponseEntity<String> rst = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
            return rst.getBody();
        } catch (Exception exception) {

        }
        return url;
    }

    @Bean
    public RestTemplate getRestTemplate(RestTemplateBuilder builder) {
        RestTemplate restTemplate = builder
                .setConnectTimeout(Duration.ofMillis(3000))
                .setReadTimeout(Duration.ofMillis(3000))
                .build();
        return restTemplate;
    }

    private HttpEntity<String> GetHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.131 Safari/537.36 Edg/92.0.902.67");
        headers.set("Referer", "http://fund.eastmoney.com");
        HttpEntity<String> entity = new HttpEntity<>(headers);
        return entity;
    }
}
