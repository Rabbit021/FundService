package com.rabbit.fundservice.dao;

import org.springframework.stereotype.Component;

/**
 * @author wangheng
 * @version V1.0
 * @Package com.rabbit.fundservice.dao
 * @date 2021/8/20 14:16
 */
@Component
public class RepositoryDao {

  private IFundItemRepository fundItemRepository;

  public void setFundItemRepository(IFundItemRepository repository) {
    this.fundItemRepository = repository;
  }

  public void savePosition() {
  }
}
