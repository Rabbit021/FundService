package com.rabbit.fundservice.service;

import com.rabbit.fundservice.data.FundMNDetailInformation;
import org.hibernate.result.Output;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.HashMap;
import java.util.Map;

//@SpringBootTest
//class SpiderServiceTest {
//    @Autowired
//    SpiderService spiderService;
//
//
//    @Test
//    void getUrl() {
//        Map<String, String> query = new HashMap<String, String>();
//        query.put("A", "1");
//
//        String url = spiderService.GetUrl("test", query);
//        System.out.println(url);
//    }
//
//    @Test
//    void getFundMNDetailInformation() {
//        FundMNDetailInformation information = spiderService.GetFundMNDetailInformation("000248");
//        System.out.println(information);
//    }
//}