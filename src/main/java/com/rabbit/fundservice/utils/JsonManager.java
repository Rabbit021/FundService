package com.rabbit.fundservice.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author wangheng
 * @version V1.0
 * @Package com.rabbit.fundservice.utils
 * @date 2021/8/19 16:41
 */
@Component
public class JsonManager {

  private final static ObjectMapper defaultMapper;
  private final static Logger logger = LoggerFactory.getLogger(JsonManager.class);

  static {
    defaultMapper = new ObjectMapper();
    defaultMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    defaultMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
  }

  public static <T> T toObject(String jsonString, Class cla, Class... clb) {
    try {
      JavaType javaType = defaultMapper.getTypeFactory().constructParametricType(cla, clb);
      return (T) defaultMapper.readValue(jsonString, javaType);
    } catch (IOException e) {
      logger.warn("parse json string error:" + jsonString, e);
    }
    return null;
  }

  public static <T> T toObject(JsonNode jsonNode, Class cla, Class... clb) {
    JavaType javaType = defaultMapper.getTypeFactory().constructParametricType(cla, clb);
    return (T) defaultMapper.convertValue(jsonNode, javaType);
  }

  public static JsonNode toJsonNode(String json, String... path) throws JsonProcessingException {
    JsonNode jsonNode = defaultMapper.readValue(json, JsonNode.class);
    for (String key : path) {
      jsonNode = jsonNode.get(key);
      break;
    }
    return jsonNode;
  }

  public static JavaType constructParametricType(Class<?> parametrized,
      Class<?>... parameterClasses) {
    return defaultMapper.getTypeFactory().constructParametricType(parametrized, parameterClasses);
  }

  public static JavaType constructParametricType(Class<?> rawType, JavaType... parameterTypes) {
    return defaultMapper.getTypeFactory().constructParametricType(rawType, parameterTypes);
  }
}
