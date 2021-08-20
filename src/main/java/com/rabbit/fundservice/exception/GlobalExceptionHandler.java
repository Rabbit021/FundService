package com.rabbit.fundservice.exception;

import com.rabbit.fundservice.common.MapResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author wangheng
 * @version V1.0
 * @Package com.rabbit.fundservice.handler
 * @date 2021/8/20 15:26 全局异常处理
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

  @ResponseBody
  @ExceptionHandler(value = Exception.class)
  public MapResponse MyExceptionHandler(Exception ex) {
    MapResponse response = new MapResponse(MapResponse.EXCEPTION, ex.getMessage());
    return response;
  }
}
