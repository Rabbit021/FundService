package com.rabbit.fundservice.jobs;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangheng
 * @version V1.0
 * @Package com.rabbit.fundservice.jobs
 * @date 2021/8/20 11:18
 */
@Configuration
public class QuartzConfiguration {

  @Bean
  public JobDetail retriveFundInfoJobDetail() {
    return JobBuilder.newJob(RetriveFundInfoJob.class).withIdentity("RetriveFundInfoJob").storeDurably().build();
  }

  @Bean
  public Trigger retriveFundInfoJobTrigger() {
    CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0 0 0 * * ? *");
    return TriggerBuilder.newTrigger().forJob(retriveFundInfoJobDetail())
        .withIdentity("retriveFundInfoJobTrigger").withSchedule(scheduleBuilder).build();
  }
}
