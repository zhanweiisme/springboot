package com.lovezhan.quartz;

import com.lovezhan.service.MyUserService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

/**
 * 这里不需要添加@component注解
 * job 实例由 SpringBeanJobFactory 创建，并放入IOC容器
 * SpringBeanJobFactory 实现了 ApplicationContextAware 接口，可以完成对象属性依赖注入
 */
public class TestJob extends QuartzJobBean {

    @Autowired
    private MyUserService myUserServiceImpl;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        System.out.println(new Date() + "quartz:" + myUserServiceImpl.getById(1));
    }
}
