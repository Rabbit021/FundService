package com.rabbit.fundservice.jobs;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @author wangheng
 * @version V1.0
 * @Package com.rabbit.fundservice.jobs
 * @date 2021/8/20 9:49
 */
@Slf4j
public class RetriveFundInfoJob extends QuartzJobBean {

  @Override
  protected void executeInternal(JobExecutionContext jobExecutionContext) {
  }
}
