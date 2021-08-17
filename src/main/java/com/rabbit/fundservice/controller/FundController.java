package com.rabbit.fundservice.controller;

import com.rabbit.fundservice.entity.FundItem;
import com.rabbit.fundservice.service.FundBizService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @RequestMapping(value = "/getName",method = RequestMethod.GET)
    public FundItem getName() {
        FundItem item = new FundItem();
        item.setFcode("000248");
        item.setFname("000248");
        fundBizService.saveFundItem(item);
        return item;
    }
    @RequestMapping(value = "/getList",method = RequestMethod.GET)
    public List<FundItem> getFundItemList() {
        List<FundItem> lst = fundBizService.getFundItemList();
        return lst;
    }
}


