package com.rabbit.fundservice.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.rabbit.fundservice.common.JacksonCriteria;
import com.rabbit.fundservice.common.MapResponse;
import com.rabbit.fundservice.entity.MyFundPosition;
import com.rabbit.fundservice.utils.JsonManager;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * @author wangheng
 * @version V1.0
 * @Package com.rabbit.fundservice.service
 * @date 2021/8/20 13:57 持仓管理服务
 */
@Service
public class PositionService extends BaseService {

  public MapResponse save(JacksonCriteria criteria) {
    MapResponse response = new MapResponse();
    MyFundPosition postion = JsonManager.toObject(criteria.getCriteria(), MyFundPosition.class);
    repositoryDao.savePosition(postion);
    response.add("item", postion);
    return response;
  }

  public MapResponse del(JacksonCriteria criteria) {
    MapResponse response = new MapResponse();
    JsonNode jsonNode = criteria.getCriteria().get("items");
    ArrayList<String> fundIds = JsonManager.toObject(jsonNode, ArrayList.class, String.class);
    repositoryDao.delPositionList(fundIds);
    return response;
  }

  public MapResponse query(JacksonCriteria criteria) {
    MapResponse response = new MapResponse();
    List<MyFundPosition> positions = repositoryDao.queryPositionList();
    response.add("items", positions);
    return response;
  }
}
