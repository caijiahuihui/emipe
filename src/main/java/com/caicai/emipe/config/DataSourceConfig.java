package com.caicai.emipe.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * 配置数据源
 *
 * @author caicai
 * @create 2021/6/4
 */
@Configuration
public class DataSourceConfig {
    // 注意，这里需要有一个@Primary注解，
    // 告诉框架有两个实现类的时候优先选择这个实现类，
    // 如果不使用会报错“required a bean of type XXX that could not be found.”
    @Primary
    // @Bean后面的括号的内容可有可无，因为我这里的写法很规范，方法名就是mainDataSource
    // 如果不一样需要@Bean加上声明的变量名称
    @Bean("mainDataSource")
    @ConfigurationProperties(prefix = "main.datasource")
    public DataSource mainDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean("otherDataSource")
    @ConfigurationProperties(prefix = "other.datasource")
    public DataSource otherDataSource() {
        return DataSourceBuilder.create().build();
    }
}
