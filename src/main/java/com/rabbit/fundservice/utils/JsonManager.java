package com.rabbit.fundservice.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author wangheng
 * @version V1.0
 * @Package com.rabbit.fundservice.utils
 * @date 2021/8/19 16:41
 */
@Component
@Slf4j
public class JsonManager {

  private final static ObjectMapper defaultMapper;

  static {
    defaultMapper = new ObjectMapper();
    defaultMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    defaultMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
  }

  public static <T> T toObject(String jsonString, Class cla, Class... clb) {
    if (!isEmpty(jsonString)) {
      try {
        JavaType javaType = defaultMapper.getTypeFactory().constructParametricType(cla, clb);
        return (T) defaultMapper.readValue(jsonString, javaType);
      } catch (IOException e) {
        log.warn("parse json string error:" + jsonString, e);
      }
    }
    return null;
  }

  public static <T> T toObject(String jsonString, TypeReference<T> typeRef) {
    if (!isEmpty(jsonString)) {
      try {
        return defaultMapper.readValue(jsonString, typeRef);
      } catch (IOException e) {
        log.warn("parse json string error:" + jsonString, e);
      }
    }
    return null;
  }

  public static <T> T toObject(String jsonString, JavaType javaType) {
    if (!isEmpty(jsonString)) {
      try {
        return (T) defaultMapper.readValue(jsonString, javaType);
      } catch (IOException e) {
        log.warn("parse json string error:" + jsonString, e);
      }
    }
    return null;
  }

  public static <T> T toObject(JsonNode jsonNode, Class cla, Class... clb) {
    if (jsonNode != null) {
      try {
        JavaType javaType = defaultMapper.getTypeFactory().constructParametricType(cla, clb);
        return (T) defaultMapper.convertValue(jsonNode, javaType);
      } catch (Exception e) {
        log.warn("parse json string error:" + jsonNode, e);
      }
    }
    return null;
  }

  public static <T> T toObject(JsonNode jsonNode, TypeReference<T> typeRef) {
    if (jsonNode != null) {
      try {
        return defaultMapper.convertValue(jsonNode, typeRef);
      } catch (Exception e) {
        log.warn("parse json string error:" + jsonNode, e);
      }
    }
    return null;
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

  private static boolean isEmpty(String json) {
    return json == "" || json == null;
  }
}
