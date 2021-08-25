package com.rabbit.fundservice.dao;

import com.rabbit.fundservice.entity.FundInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author wangheng
 * @version V1.0
 * @Package com.rabbit.fundservice.dao
 * @date 2021/8/23 17:25
 */
@Repository
public interface FundInfoRepository extends AbstractRepository<FundInfo, String> {

}
