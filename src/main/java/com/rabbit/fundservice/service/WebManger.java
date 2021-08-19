package com.rabbit.fundservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @author wangheng
 * web数据请求封装
 */
@Component
@Scope("singleton")

public class WebManger {
    private static final Logger logger = LoggerFactory.getLogger(WebManger.class);
    final RestTemplate restTemplate;

    public WebManger(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * get请求天天基金App数据
     */
    public String getString(String url) {
        try {
            HttpHeaders headers = GetHeaders();
            HttpEntity<String> entity = new HttpEntity<>(headers);
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
            return response.getBody();
        } catch (Exception exception) {
            logger.error(exception.getMessage());
            return "";
        }
    }


    /**
     * Post请求天天基金App数据
     */
    public String postString(String url, MultiValueMap<String, String> map) {
        try {
            HttpHeaders headers = GetHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(map, headers);
            ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);
            return response.getBody();
        } catch (Exception exp) {
            logger.error(exp.getMessage());
            return "";
        }
    }

    private HttpHeaders GetHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.131 Safari/537.36 Edg/92.0.902.67");
        headers.set("Referer", "http://fund.eastmoney.com");
        return headers;
    }
}
