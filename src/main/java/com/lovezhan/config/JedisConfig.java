package com.lovezhan.config;

import org.springframework.boot.autoconfigure.data.redis.JedisClientConfigurationBuilderCustomizer;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.stereotype.Component;

/**
 * 实现JedisClientConfigurationBuilderCustomizer接口可以定制 jedis客户端参数
 * 这个类会在JedisConnectionConfiguration类中获取处理
 */
@Component
public class JedisConfig implements JedisClientConfigurationBuilderCustomizer {

    @Override
    public void customize(JedisClientConfiguration.JedisClientConfigurationBuilder clientConfigurationBuilder) {
        clientConfigurationBuilder.clientName("Jedisohhh");
    }
}
