package com.rabbit.fundservice.data;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wangheng
 * @version V1.0
 * @Package com.rabbit.fundservice.data
 * @date 2021/8/18 19:50
 */
@Data
@NoArgsConstructor
public class Fundstock {

  public String gpdm; // 股票代码
  public String gpjc; // 股票名称
  public double jzbl; // 净值占比
  public String texch;
  public String newtexch;
  public String isinvisbl;
  public String pctnvchgtype; // 类型
  public String pctnvchg; // 个股变化
  public String indexcode; // 主题编号
  public String indexname; // 主题名称
}
