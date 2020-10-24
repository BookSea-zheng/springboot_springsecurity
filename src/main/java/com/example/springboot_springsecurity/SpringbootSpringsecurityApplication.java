package com.example.springboot_springsecurity;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import sun.awt.SunHints;

@SpringBootApplication
@MapperScan("com.example.springboot_springsecurity.mapper")
public class SpringbootSpringsecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSpringsecurityApplication.class, args);
    }

}
