package com.caicai.emipe.config;

import com.caicai.emipe.persistence.entity.Menu;
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

    @Bean
    public Menu menu() {
        Menu menu = new Menu();
        menu.setIcon("thisIcon");
        return menu;
    }
}
