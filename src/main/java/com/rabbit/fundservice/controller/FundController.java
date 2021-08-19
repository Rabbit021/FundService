package com.rabbit.fundservice.controller;

import com.rabbit.fundservice.entity.FundItem;
import com.rabbit.fundservice.service.FundBizService;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangheng
 */
@RestController
@RequestMapping(value = "/fund")
public class FundController {

  public final FundBizService fundBizService;

  public FundController(FundBizService fundBizService) {
    this.fundBizService = fundBizService;
  }

  @RequestMapping(value = "/getName", method = RequestMethod.GET)
  public FundItem getName() {
    FundItem item = new FundItem();
    item.setFcode("000248");
    item.setFname("000248");
    fundBizService.saveFundItem(item);
    return item;
  }

  @RequestMapping(value = "/getList", method = RequestMethod.GET)
  public List<FundItem> getFundItemList() {
    return fundBizService.getFundItemList();
  }
}


