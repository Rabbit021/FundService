package com.rabbit.fundservice.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.rabbit.fundservice.common.JacksonCriteria;
import com.rabbit.fundservice.common.MapResponse;
import com.rabbit.fundservice.service.PositionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangheng
 */
@RestController
@RequestMapping("/position")
public class PositionController {

  private final PositionService positionService;

  public PositionController(PositionService positionService) {
    this.positionService = positionService;
  }

  @PostMapping("/save")
  public MapResponse save(@RequestBody JacksonCriteria criteria) {
    return positionService.save(criteria);
  }

  @PostMapping("/delete")
  public MapResponse del(@RequestBody JacksonCriteria criteria) {
return  positionService.del(criteria);
  }

  @PostMapping("/query")
  public MapResponse query(@RequestBody JacksonCriteria criteria) {
  return  positionService.query(criteria);
  }
}


