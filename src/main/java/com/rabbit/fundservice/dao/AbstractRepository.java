package com.rabbit.fundservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author wangheng
 * @version V1.0
 * @Package com.rabbit.fundservice.dao
 * @date 2021/8/23 17:32
 */
@NoRepositoryBean
public interface AbstractRepository<T, I> extends JpaRepository<T, I>, QuerydslPredicateExecutor<T> {

}
