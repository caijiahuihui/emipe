package com.caicai.emipe.persistence.entity;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;
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
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Person implements Serializable {

    private static final long serialVersionUID = 4272671878981449751L;
    @Value("${person.name}")
    private String name;

    @Value("${person.age}")
    private Integer age;

    @Value("${person.address}")
    private String address;

    @Value("${person.description}")
    private String description;

}
