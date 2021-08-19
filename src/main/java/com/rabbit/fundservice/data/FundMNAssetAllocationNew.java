package com.rabbit.fundservice.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rabbit.fundservice.converter.String2DoubleDeserializer;
import java.util.Date;

/**
 * @author wangheng
 * @version V1.0
 * @Package com.rabbit.fundservice.data
 * @date 2021/8/18 16:22
 */
public class FundMNAssetAllocationNew {
  @JsonProperty("GP")
  @JsonDeserialize(using = String2DoubleDeserializer.class)
  public double stockPercent;

  @JsonProperty("ZQ")
  @JsonDeserialize(using = String2DoubleDeserializer.class)
  public double bondPercent;

  @JsonProperty("HB")
  @JsonDeserialize(using = String2DoubleDeserializer.class)
  public double cashPercent;

  @JsonProperty("QT")
  @JsonDeserialize(using = String2DoubleDeserializer.class)
  public double otherPercent;

  @JsonProperty("JJ")
  @JsonDeserialize(using = String2DoubleDeserializer.class)
  public double fundPercent;

  @JsonProperty("JZC")
  @JsonDeserialize(using = String2DoubleDeserializer.class)
  public double nav; // 基金规模
}
