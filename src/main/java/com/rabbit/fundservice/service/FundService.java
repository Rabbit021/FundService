package com.rabbit.fundservice.service;

import com.rabbit.fundservice.dao.IFundItemRepository;
import com.rabbit.fundservice.entity.FundItem;
import com.sun.org.apache.bcel.internal.generic.FCMPG;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wangheng
 */
@Service
@Data
public class FundService {
    private final IFundItemRepository fundItemRepository;

    public FundService(IFundItemRepository fundItemRepository) {
        this.fundItemRepository = fundItemRepository;
    }

    public List<FundItem> getFundItemList() {
        List<FundItem> lst = fundItemRepository.findAll();
        return lst;
    }

    public  void saveFundItem(FundItem item){
        fundItemRepository.save(item);
    }
}
