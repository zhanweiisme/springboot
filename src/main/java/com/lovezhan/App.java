package com.lovezhan;

import com.alibaba.druid.pool.DruidDataSource;
import com.lovezhan.bean.Car;
import com.lovezhan.bean.User;
import com.lovezhan.config.MyConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Date;

// @EnableTransactionManagement
// @EnableAspectJAutoProxy
@EnableAsync // 异步执行
@EnableScheduling // 开启任务调度
@EnableCaching
@MapperScan("com.lovezhan.mapper")
//@ServletComponentScan({"com.lovezhan.filter"})
@ConfigurationPropertiesScan
@SpringBootApplication
public class App {

    private User user1;

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(App.class);
        springApplication.setBannerMode(Banner.Mode.OFF);
        final ConfigurableApplicationContext run = springApplication.run(args);

        // final ConfigurableApplicationContext run = SpringApplication.run(App.class, args);
        System.out.println(run.getClass());

        App bean = run.getBean(App.class);
        System.out.println(bean);

        Date date = new Date();


        User user01 = run.getBean("user01", User.class);
        User user02 = run.getBean("user01", User.class);
        System.out.println(user01 == user02);
        Car ford = run.getBean(Car.class);

        System.out.println(user01);
        System.out.println(ford);

        MyConfig myConfig = run.getBean(MyConfig.class);
        User user1 = myConfig.user01();
        User user2 = myConfig.user01();
        System.out.println(user1 == user2);

        HikariDataSource dataSourceOne = run.getBean("dataSourceOne", HikariDataSource.class);
        System.out.println("dataSourceOne---" + dataSourceOne.getClass());

        DruidDataSource druidDataSource = run.getBean(DruidDataSource.class);
        System.out.println("druidDataSource---" + druidDataSource.getClass());

        run.publishEvent(new ApplicationEvent(new String("这是一个自定义的事件")) {});
        run.close();
    }

}
