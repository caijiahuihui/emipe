package com.caicai.emipe.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Map;

/**
 * @author caicai
 * @create 2021/6/4
 */
@Configuration
// 启用事务管理注解
@EnableTransactionManagement
// 启用JPA仓库注解，
// 其中第一个属性对应Bean名称为”mainEntityManagerFactory“的对象，声明了该数据源所使用的对象管理类工厂
// 第二个属性声明事务管理器，对应名称为”mainTransactionManager“的JavaBean
// 第三个属性表示dao层所在的包
@EnableJpaRepositories(entityManagerFactoryRef = "mainEntityManagerFactory", transactionManagerRef = "mainTransactionManager",
        basePackages = {"com.caicai.emipe.persistence.main"})
public class MainDataSourceConfig {

    @Autowired
    @Qualifier("mainDataSource")
    private DataSource mainDataSource;

    @Autowired(required = false)
    private JpaProperties jpaProperties;


    @Autowired
    private HibernateProperties hibernateProperties;

    // 配置EntityManagerFactory，因为一共有两个数据源，
    // 其中一个在配置EntityManagerFactory时需要加@Primary注解
    @Primary
    @Bean(name = "mainEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean mainEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder.dataSource(mainDataSource)
                //设置entity所在位置
                .packages("com.caicai.emipe.persistence.main")
                .persistenceUnit("mainPersistenceUnit")
                .properties(getVendorProperties())
                .build();
    }

    private Map<String, Object> getVendorProperties() {
        return hibernateProperties.determineHibernateProperties(jpaProperties.getProperties(), new HibernateSettings());
    }

    // 配置事务管理器，也需要添加@Primary注解
    @Primary
    @Bean(name = "mainTransactionManager")
    public PlatformTransactionManager mainTransactionManager(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(mainEntityManagerFactory(builder).getObject());
    }
}
