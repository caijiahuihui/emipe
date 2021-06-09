package com.caicai.emipe.persistence.main.entity;

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
    public String name;

    private Integer age;

    private String address;

    private String description;

    public void testStatic(String str) {
        System.out.println(str + name);
    }

    static String HHH = "dasda";

    public static void testIt() {
        System.out.println(Person.HHH);
    }

}
