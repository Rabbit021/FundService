package com.rabbit.fundservice.dao;

import com.rabbit.fundservice.entity.MyFundPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author wangheng
 */
@Repository
public interface MyFundPositionRepository extends JpaRepository<MyFundPosition, String> {

}
