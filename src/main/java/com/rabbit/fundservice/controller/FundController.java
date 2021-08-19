package com.rabbit.fundservice.controller;

import com.rabbit.fundservice.data.FundMNUniqueInfo;
import com.rabbit.fundservice.service.FundBizService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangheng
 */
@RestController
public class FundController {

  public final FundBizService fundBizService;

  public FundController(FundBizService fundBizService) {
    this.fundBizService = fundBizService;
  }

  @GetMapping("/getFundMNUniqueInfo")
  public List<FundMNUniqueInfo> getFundMNUniqueInfo() {
    return fundBizService.getFundMNUniqueInfoList("000248");
  }
}


