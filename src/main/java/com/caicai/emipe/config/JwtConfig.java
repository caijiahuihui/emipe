package com.caicai.emipe.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * jwt配置类
 *
 * @author caicai
 * @create 2021/5/31
 */
@ConfigurationProperties(prefix = "jwt")
@Component
@Data
public class JwtConfig {
    private String secret;

    private long expire;

    private String header;

    /**
     * 签发token
     *
     * @param subject
     * @return
     */
    public String generateToken(String subject) {
        Date date = new Date();
        Date expireDate = new Date(date.getTime() + expire);
        return Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(date)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    /**
     * 验签获取用户名
     *
     * @param token
     * @return
     */
    public String parseToken(String token) {
        return getClaimsFromToken(token).getSubject();
    }

    public Claims getClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }


}
