package com.rabbit.fundservice.dao;

import com.rabbit.fundservice.entity.FundItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author wangheng
 */
@Repository
public interface IFundItemRepository extends JpaRepository<FundItem, String> {

}
