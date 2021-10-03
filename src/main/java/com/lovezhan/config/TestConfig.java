package com.lovezhan.config;

import com.lovezhan.interceptor.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * 实现WebMvcConfigurer接口，添加@Configuration，即在自动配置的基础上添加可定制化配置MVC相关配置
 * 例如添加拦截器、格式化器、视图控制器等
 */
@Configuration
public class TestConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor());
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/api/**");
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        converters.add();  添加新的消息转换器，用于渲染 @ResponseBody 或 @RestController
    }
}
