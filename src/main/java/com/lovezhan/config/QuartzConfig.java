package com.lovezhan.config;

import com.lovezhan.quartz.TestJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail TestJobDetail() {
        return JobBuilder.newJob(TestJob.class)
                .withIdentity("TestJob")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger TestTrigger() {
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0/30 * * * * ?");
        return TriggerBuilder.newTrigger()
                .forJob(TestJobDetail())
                .withIdentity("TestTrigger")
                .withSchedule(cronScheduleBuilder)
                .build();
    }

}
