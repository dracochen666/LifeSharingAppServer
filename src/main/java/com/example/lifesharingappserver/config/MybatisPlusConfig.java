package com.example.lifesharingappserver.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.example.lifesharingappserver.mapper")
public class MybatisPlusConfig {
    
}
