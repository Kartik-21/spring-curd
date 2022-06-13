package com.kartik.curd.entity.bean_demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class D {

    @Bean
    public D run() {
        System.out.println("D.run");
        return new D();
    }
}
