package com.rabbit.fundservice.data;

import lombok.Data;

/**
 * @author wangheng
 * @version V1.0
 * @Package com.rabbit.fundservice.data
 * @date 2021/8/18 19:51
 */
@Data
public class Fundbood {
  public String zqdm; // 代码
  public String zqmc; // 名称
  public double zjzbl; // 净值占比
  public String isbroken;
}
