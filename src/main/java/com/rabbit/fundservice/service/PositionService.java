package com.rabbit.fundservice.service;

import com.rabbit.fundservice.common.JacksonCriteria;
import com.rabbit.fundservice.common.MapResponse;
import com.rabbit.fundservice.dao.RepositoryDao;
import com.rabbit.fundservice.entity.MyFundPosition;
import com.rabbit.fundservice.utils.JsonManager;
import org.springframework.stereotype.Service;

/**
 * @author wangheng
 * @version V1.0
 * @Package com.rabbit.fundservice.service
 * @date 2021/8/20 13:57 持仓管理服务
 */
@Service
public class PositionService {

  private final RepositoryDao repositoryDao;

  public PositionService(RepositoryDao repositoryDao) {
    this.repositoryDao = repositoryDao;
  }

  public MapResponse save(JacksonCriteria criteria) {
    MapResponse response = new MapResponse();
    MyFundPosition postion = JsonManager.toObject(criteria.getCriteria(), MyFundPosition.class);
    repositoryDao.savePosition(postion);
    response.add("item", postion);
    return response;
  }

  public MapResponse del(JacksonCriteria criteria) {
    return null;
  }

  public MapResponse query(JacksonCriteria criteria) {
    return null;
  }
}
