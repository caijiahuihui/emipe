package com.caicai.emipe.controller;

import com.caicai.emipe.persistence.main.entity.Person;
import com.caicai.emipe.service.WechatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author caicai
 * @create 2021/4/28
 */
@RequestMapping("/wechat")
@RestController
@Slf4j
@EnableConfigurationProperties({Person.class})
public class WechatController {

    @Autowired
    private WechatService wechatService;

    @GetMapping("native")
    public String wechatNative() throws Exception {
        return wechatService.nativePay();
    }

    @GetMapping("app")
    public String wechatApp() {
        return null;
    }

}
