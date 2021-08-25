package com.rabbit.fundservice.service;

import com.rabbit.fundservice.dao.MyFundPositionRepository;
import com.rabbit.fundservice.dao.RepositoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wangheng
 * @version V1.0
 * @Package com.rabbit.fundservice.service
 * @date 2021/8/23 17:39
 */
@Service
public class BaseService {

  @Autowired
  protected RepositoryDao repositoryDao;
  @Autowired
  protected MyFundPositionRepository fundItemRepository;
  @Autowired
  protected SpiderService spiderService;
}
