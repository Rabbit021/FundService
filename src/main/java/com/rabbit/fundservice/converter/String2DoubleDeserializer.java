package com.rabbit.fundservice.converter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;

/**
 * @author wangheng
 * @version V1.0
 * @Package com.rabbit.fundservice.converter
 * @date 2021/8/19 18:52
 */
@Slf4j
public class String2DoubleDeserializer extends JsonDeserializer<Double> {
  @Override
  public Double deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
    try {
      String val = jsonParser.getText();
      return Double.parseDouble(val);
    } catch (Exception ex) {
      log.error(jsonParser.getText() + " 转换失败 " + ex.getMessage());
      return new Double(0);
    }
  }
}
