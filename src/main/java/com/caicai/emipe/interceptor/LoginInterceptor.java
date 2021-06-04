package com.caicai.emipe.interceptor;

import com.caicai.emipe.config.JwtConfig;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author caicai
 * @create 2021/5/31
 */
@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Resource
    private JwtConfig jwtConfig;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String url = request.getRequestURI();
        // 如果包含login，则直接去验证用户名密码，不需要去验证token
        if (url.contains("/login")) {
            return true;
        }
        String token = request.getHeader(jwtConfig.getHeader());
        if (StringUtils.isEmpty(token)) {
            token = request.getParameter(jwtConfig.getHeader());
        }
        if (token.isEmpty()) {
            return false;
        }
        String subject = jwtConfig.parseToken(token);
        request.setAttribute("userName", subject);
        return true;
    }

}
