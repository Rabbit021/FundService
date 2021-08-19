package com.rabbit.fundservice.service;

import com.rabbit.fundservice.data.FundMNAssetAllocationNew;
import com.rabbit.fundservice.data.FundMNDetailInformation;
import com.rabbit.fundservice.data.FundMNUniqueInfo;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpiderServiceTest {

  @Autowired
  SpiderService spiderService;
  private String code = "000248";

  @Test
  void getFundMNDetailInformation() {
    FundMNDetailInformation information = spiderService.getFundMNDetailInformation(code);
    System.out.println(information);
  }

  @Test
  void postFundMNUniqueInfo() {
    FundMNUniqueInfo information = spiderService.getFundMNUniqueInfo(code);
    System.out.println(information);
  }

  @Test
  void Test() {
    ArrayList<String> list = new ArrayList<>();
    for (String itr : list) {

    }
  }

  @Test
  void getFundMNAssetAllocationNew() {
    FundMNAssetAllocationNew allocationNew = spiderService
        .getFundMNAssetAllocationNew(code);
  }
}