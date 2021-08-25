package com.rabbit.fundservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;

/**
 * @author wangheng
 * @version V1.0
 * @Package com.rabbit.fundservice.entity
 * @date 2021/8/22 15:53
 * 关注的基金
 */
@Data
@Entity
public class MyFollowFund {

  @Id
  @GeneratedValue
  private Long id;
  private String fcode;
}
