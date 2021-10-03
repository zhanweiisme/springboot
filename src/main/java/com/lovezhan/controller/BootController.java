package com.lovezhan.controller;

import com.lovezhan.bean.Car;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class BootController {

    @Autowired
    Car car;

    @RequestMapping("car")
    public Car car(){
        return car;
    }

    @RequestMapping("hello")
    public String hello(){
        log.info("hello请求过来了。。。。。");
        int a = 1/0;
        return "hello";
    }

    @RequestMapping("logTest")
    public void logTest() {
        for (int i = 0; i < 100000; i++) {
            log.info("现在是第几次循环呀" + i);
        }
    }

}
