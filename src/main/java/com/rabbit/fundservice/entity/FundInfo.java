package com.rabbit.fundservice.entity;

import java.io.PipedReader;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

/**
 * @author wangheng
 * @version V1.0 基金信息表
 * @Package com.rabbit.fundservice.entity
 * @date 2021/8/22 15:57
 */
@Data
@Entity
public class FundInfo {
  @Id
  private  String fcode;

}
