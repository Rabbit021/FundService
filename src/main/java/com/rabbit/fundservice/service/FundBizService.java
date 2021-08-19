package com.rabbit.fundservice.service;

import com.rabbit.fundservice.dao.IFundItemRepository;
import com.rabbit.fundservice.entity.FundItem;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wangheng
 * 基金业务层
 */
@Service
public class FundBizService {
    private final IFundItemRepository fundItemRepository;

    public FundBizService(IFundItemRepository fundItemRepository) {
        this.fundItemRepository = fundItemRepository;
    }

    public List<FundItem> getFundItemList() {
        return fundItemRepository.findAll();
    }

    public void saveFundItem(FundItem item) {
        fundItemRepository.save(item);
    }
}
