package com.caicai.emipe.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author caicai
 * @create 2021/5/31
 */
@ConfigurationProperties(prefix = "jwt")
@Component
public class JwtConfig {
    private String secret;

    private long expire;

    private String header;

    public String getToken(String subject) {
        Date date = new Date();
        Date expireDate = new Date(date.getTime() + expire);
        return null;
    }


    public static void main(String[] args) {
        Long aa = 100L;
        long bb = 100;
        Long cc = (Long) bb;
        System.out.println("-----------------" + aa.equals(cc) + (aa == cc));
    }

}
