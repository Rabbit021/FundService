package com.rabbit.fundservice.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import lombok.Data;
import org.springframework.lang.Nullable;

/**
 * @author wangheng
 * 我的基金持仓
 */
@Data
@Entity
public class MyFundPosition implements Serializable {
  @Id
  private String fcode; // 代码
  private Double cost;  // 成本
  private Double share; // 份额
}
