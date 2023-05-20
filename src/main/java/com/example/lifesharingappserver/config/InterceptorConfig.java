package com.example.lifesharingappserver.config;

import com.example.lifesharingappserver.config.interceptor.JwtInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(jwtInterceptor())
//                .addPathPatterns("/**")  // 拦截所有请求，通过判断token是否合法来决定是否需要登录
//                .excludePathPatterns("/User/login", "/User/register");
    }

    @Bean
    public JwtInterceptor jwtInterceptor() {
        return new JwtInterceptor();
    }

//    xiaole token: eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI0IiwiZXhwIjoxNjg0NDk0OTMwfQ.PhWnuFWsWJ99mfa7Ze9WieYaHd2ghHjq1UMT4BdY_5E
}
