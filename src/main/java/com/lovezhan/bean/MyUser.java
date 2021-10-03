package com.lovezhan.bean;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;

@Data
@Validated
public class MyUser {
    private Long id;
    private String name;
    private Integer age;
    @Email
    private String email;
}
