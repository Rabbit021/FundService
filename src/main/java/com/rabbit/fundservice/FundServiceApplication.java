package com.rabbit.fundservice;

import com.rabbit.fundservice.jobs.RetriveFundInfoJob;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author wangheng
 */
@SpringBootApplication
public class FundServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(FundServiceApplication.class, args);
  }
}
