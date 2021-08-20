package com.rabbit.fundservice.common;

import java.util.HashMap;
import java.util.Map;
import lombok.Data;

/**
 * @author wangheng
 * @version V1.0
 * @Package com.rabbit.fundservice.common
 * @date 2021/8/20 13:51
 */
@Data
public class MapResponse extends BaseResponse<Map<String, Object>> {
  public MapResponse() {
    super();
    super.setResult(SUCCESS);
  }

  public void add(String prop, Object val) {
    if (data == null) {
      data = new HashMap<String, Object>();
    }
    data.put(prop, val);
  }
}
