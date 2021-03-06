package com.rabbit.fundservice.service;

import com.rabbit.fundservice.dao.MyFundPositionRepository;
import com.rabbit.fundservice.data.FundMNUniqueInfo;
import com.rabbit.fundservice.entity.MyFundPosition;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * @author wangheng 基金业务层
 */
@Service
public class FundBizService extends BaseService {
  

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
