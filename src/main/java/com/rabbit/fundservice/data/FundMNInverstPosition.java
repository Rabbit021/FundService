package com.rabbit.fundservice.data;

import java.util.List;
import lombok.Data;

/**
 * @author wangheng
 * @version V1.0
 * @Package com.rabbit.fundservice.data
 * @date 2021/8/18 16:08 基金持仓
 **/
@Data
public class FundMNInverstPosition {

  // 基金持仓
  public List<Fundstock> fundStocks;

  // 债券持仓
  public List<Fundbood> fundboods;

  // 等等看看 
  public List<Object> fundfofs;

  // etf联结
  public String etfcode;
  public String etfshortname;

}
