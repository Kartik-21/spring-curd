package com.kartik.curd.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "demo")
//@RefreshScope when client is refreshing the bean when actuator endpoint /refresh hit
public class DemoConfig {

    private String name;

    private int age;

    @Override
    public String toString() {
        return "DemoConfig{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
