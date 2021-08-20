package com.rabbit.fundservice.service;

import com.rabbit.fundservice.dao.IFundItemRepository;
import com.rabbit.fundservice.data.FundMNUniqueInfo;
import com.rabbit.fundservice.entity.MyFundPosition;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * @author wangheng 基金业务层
 */
@Service
public class FundBizService {

  private final IFundItemRepository fundItemRepository;
  private final SpiderService spiderService;

  public FundBizService(IFundItemRepository fundItemRepository, SpiderService spiderService) {
    this.fundItemRepository = fundItemRepository;
    this.spiderService = spiderService;
  }

  public List<MyFundPosition> getFundItemList() {
    return fundItemRepository.findAll();
  }

  public void saveFundItem(MyFundPosition item) {
    fundItemRepository.save(item);
  }
  public List<FundMNUniqueInfo> getFundMNUniqueInfoList(String... codes) {
    ArrayList<FundMNUniqueInfo> uniqueInfos = new ArrayList<>();
    for (String code : codes) {
      FundMNUniqueInfo info = spiderService.getFundMNUniqueInfo(code);
      uniqueInfos.add(info);
    }
    return uniqueInfos;
  }


}
