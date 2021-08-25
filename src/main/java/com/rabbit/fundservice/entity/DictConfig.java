package com.rabbit.fundservice.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

/**
 * @author wangheng
 * @version V1.0
 * @Package com.rabbit.fundservice.entity
 * @date 2021/8/22 15:42 字典配置
 */

@Data
@Entity
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class DictConfig implements Serializable {

  @Id
  @GeneratedValue(generator = "jpa-uuid")
  private String Id;
  private String type;
  private String code;
  private String name;
}
