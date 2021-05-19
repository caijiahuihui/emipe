package com.caicai.emipe.persistence.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author caicai
 * @create 2021/5/10
 */
@Configuration
@Component
@Data
@ConfigurationProperties(prefix = "test")
@PropertySource("classpath:test.properties")
public class Person implements Serializable {

    private static final long serialVersionUID = 4272671878981449751L;
    private String name;

    private Integer age;

    private String address;

    private String description;

}
