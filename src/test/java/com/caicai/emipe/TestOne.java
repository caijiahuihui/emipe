package com.caicai.emipe;

import com.caicai.emipe.config.JwtConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author caicai
 * @create 2021/3/12
 */
@RunWith(SpringRunner.class)
@SpringBootTest(properties = "classpath:/application-dev.properties")
public class TestOne {

    @Resource
    private JwtConfig jwtConfig;

    @Test
    public void test1() {
        String subject = "user";
        String token = jwtConfig.generateToken(subject);
        System.out.println("---------token------------ " + token);
        String parseSub = jwtConfig.parseToken(token);
        System.out.println(parseSub + "------------------");
    }

    @Test
    public void test2() {
        System.out.println("ssss");
    }

}
