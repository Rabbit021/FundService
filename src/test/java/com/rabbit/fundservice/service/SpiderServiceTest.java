package com.rabbit.fundservice.service;

import com.rabbit.fundservice.data.FundMNDetailInformation;
import com.rabbit.fundservice.data.FundMNUniqueInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpiderServiceTest {
    @Autowired
    SpiderService spiderService;

    @Test
    void getFundMNDetailInformation() {
        FundMNDetailInformation information = spiderService.GetFundMNDetailInformation("000248");
        System.out.println(information);
    }

    @Test
    void postFundMNUniqueInfo() {
        FundMNUniqueInfo information = spiderService.PostFundMNUniqueInfo("000248");
        System.out.println(information);
    }
}