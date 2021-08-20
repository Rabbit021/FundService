package com.rabbit.fundservice.dao;

import com.rabbit.fundservice.entity.MyFundPosition;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author wangheng
 * @version V1.0
 * @Package com.rabbit.fundservice.dao
 * @date 2021/8/20 14:16
 */
@Component
public class RepositoryDao {

  private MyFundPositionRepository myFundPositionRepository;

  @Autowired
  public void setMyFundPositionRepository(MyFundPositionRepository repository) {
    this.myFundPositionRepository = repository;
  }

  public void savePosition(MyFundPosition position) {
    myFundPositionRepository.saveAndFlush(position);
  }

  public void delPositionList(List<String> fundIs) {
    List<String> del = new ArrayList<>();
    for (String id : fundIs) {
      boolean exists = myFundPositionRepository.existsById(id);
      if (exists) {
        del.add(id);
      }
    }
    myFundPositionRepository.deleteAllById(del);
  }

  public List<MyFundPosition> queryPositionList() {
    List<MyFundPosition> all = myFundPositionRepository.findAll();
    return all;
  }
}
