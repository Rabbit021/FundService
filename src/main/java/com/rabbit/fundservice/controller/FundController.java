package com.rabbit.fundservice.controller;

import com.rabbit.fundservice.entity.FundItem;
import com.rabbit.fundservice.service.FundService;
import com.sun.org.apache.xalan.internal.xsltc.dom.UnionIterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wangheng
 */
@RestController
@RequestMapping(value = "/fund")
public class FundController {

    public final FundService fundService;

    public FundController(FundService fundService) {
        this.fundService = fundService;
    }

    @RequestMapping(value = "/getName",method = RequestMethod.GET)
    public FundItem getName() {
        FundItem item = new FundItem();
        item.setFcode("000248");
        item.setFname("000248");
        fundService.saveFundItem(item);
        return item;
    }
    @RequestMapping(value = "/getList",method = RequestMethod.GET)
    public List<FundItem> getFundItemList() {
        List<FundItem> lst = fundService.getFundItemList();
        return lst;
    }
}


