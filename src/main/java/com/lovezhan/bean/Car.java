package com.lovezhan.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@ConfigurationProperties(prefix = "mycar")
@Validated //数据校验
@Data // getter setter 方法
@ToString // toString 方法
@AllArgsConstructor // 全参构造器
@NoArgsConstructor // 无参构造器
public class Car {
    @NotNull(message = "car类型不能为空值")
    private String type;
    private String term;
    @Valid
    private MyUser myUser;
}
