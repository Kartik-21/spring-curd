package com.kartik.curd.entity.bean_demo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("B")
//@Primary
public class B implements A {

    @Override
    public void run() {

    }
}


