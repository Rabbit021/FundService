package com.rabbit.fundservice.dao;

import com.rabbit.fundservice.entity.DictConfig;
import com.rabbit.fundservice.entity.MyFundPosition;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author wangheng
 */
@Repository
public interface MyFundPositionRepository extends AbstractRepository<MyFundPosition, String> {
}

