package com.rabbit.fundservice.common;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;

/**
 * @author wangheng
 * @version V1.0
 * @Package com.rabbit.fundservice.common
 * @date 2021/8/20 13:45 请求参数的基本格式
 */
@Data
public class JacksonCriteria {

  private JsonNode criteria;
}
