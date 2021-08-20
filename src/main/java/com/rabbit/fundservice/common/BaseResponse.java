package com.rabbit.fundservice.common;

import lombok.Data;

/**
 * @author wangheng
 * @version V1.0
 * @Package com.rabbit.fundservice.common
 * @date 2021/8/20 13:47
 */
@Data
public class BaseResponse<T> {

  public static final String SUCCESS = "success";
  public static final String FAIL = "fail";
  public static final String EXCEPTION = "exception";

  protected T data;
  private String result;
  private String message;

  public BaseResponse() {
    super();
    this.result = SUCCESS;
  }

  public BaseResponse(String result, String message) {
    super();
    this.result = result;
    this.message = message;
  }

  public void setFail(String message) {
    setResult(FAIL);
    setMessage(message);
  }

  public boolean success() {
    return SUCCESS.equals(this.result);
  }
}
