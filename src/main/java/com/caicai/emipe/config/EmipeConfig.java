package com.caicai.emipe.config;

import com.caicai.emipe.persistence.main.entity.Menu;
import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author caicai
 * @create 2021/5/14
 */
@Configuration
@Data
public class EmipeConfig {
    /**
     * 关于@Bean：
     * Spring的@Bean注解用于告诉方法，产生一个Bean对象，
     * 然后这个Bean对象交给Spring管理。
     * 产生这个Bean对象的方法Spring只会调用一次，
     * 随后这个Spring将会将这个Bean对象放在自己的IOC容器中。
     *
     * @return
     */
    @Bean
    public Menu menu() {
        Menu menu = new Menu();
        menu.setIcon("thisIcon");
        return menu;
    }
}
