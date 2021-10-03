package com.lovezhan.config;

import com.lovezhan.bean.Car;
import com.lovezhan.bean.User;
import com.lovezhan.filter.MyFilter;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Configuration(proxyBeanMethods=false)
public class MyConfig {

    @Bean
    public User user01(){
        return new User(1,"shu");
    }

    public Car ford(){
        return new Car();
    }

    /**
     * 定制
     * RequestMappingHandlerMapping
     * RequestMappingHandlerAdapter
     * ExceptionHandlerExceptionResolver
     * @return
     */
    @Bean
    public WebMvcRegistrations webMvcRegistrations() {
        return new WebMvcRegistrations() {
            @Override
            public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
                RequestMappingHandlerMapping requestMappingHandlerMapping = new RequestMappingHandlerMapping();

                return requestMappingHandlerMapping;
            }
        };
    }

    /**
     * 添加一个servlet Filter
     * 或者使用 @WebFilter + @ServletComponentScan 注解实现
     * @return
     */
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean<MyFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        MyFilter myFilter = new MyFilter();
        filterRegistrationBean.setFilter(myFilter);
        filterRegistrationBean.setOrder(Ordered.LOWEST_PRECEDENCE);
        filterRegistrationBean.addUrlPatterns("/test/*");
        filterRegistrationBean.addServletNames("MyFilterName");
        return filterRegistrationBean;
    }

}
