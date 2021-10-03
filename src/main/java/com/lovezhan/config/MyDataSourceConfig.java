package com.lovezhan.config;


import com.alibaba.druid.pool.DruidDataSource;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration(proxyBeanMethods = false)
public class MyDataSourceConfig {


    @Bean
    @ConfigurationProperties(prefix = "my.datasource.one")
    public HikariDataSource dataSourceOne() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Primary
    @Bean
    @ConfigurationProperties(prefix = "my.datasource.two")
    public DruidDataSource dataSourceTwo() {
        return DataSourceBuilder.create().type(DruidDataSource.class).build();
    }

}
