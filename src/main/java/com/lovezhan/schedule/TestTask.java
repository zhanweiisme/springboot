package com.lovezhan.schedule;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TestTask {

//    @Scheduled(fixedDelay = 3000)
    public void printOne() throws InterruptedException {
        System.out.println("111111111111111111---" + Thread.currentThread().getName() + "---" + new Date());
        Thread.sleep(3000);
    }

//    @Scheduled(fixedDelay = 2000)
    public void printTwo() {
        System.out.println("2222222222---" + Thread.currentThread().getName() + "---" + new Date());
    }

    @Async
//    @Scheduled(fixedDelay = 2000)
    public void printThree() {
        System.out.println("3333---" + Thread.currentThread().getName() + "---" + new Date());
    }


}
