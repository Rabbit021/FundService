package com.rabbit.fundservice.dao;

import com.rabbit.fundservice.entity.DictConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DictConfigRepository extends AbstractRepository<DictConfig, String> {

}
