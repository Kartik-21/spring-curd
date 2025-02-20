package com.kartik.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Author: Kartik Jain
 * version: 1.0
 * since: 16 Jun 2022
 */

/**
 * read properties file from different location
 */

@Configuration
@PropertySource("classpath:/dev/curdconfig.yml")
public class LoadConfigProperty {

    @Value("${k}")
    private String name;

    public LoadConfigProperty() {
    }

    public LoadConfigProperty(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CurdConfig{" +
                "name='" + name + '\'' +
                '}';
    }
}
