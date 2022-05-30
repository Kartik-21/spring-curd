package com.kartik.curd.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class CustomCommandLine implements CommandLineRunner {

    @Autowired
    private DemoConfig demoConfig;

    private static final Logger logger = LoggerFactory.getLogger(CustomCommandLine.class);

    @Value("${api.key: not found}")
    private String name;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("---------------------------------------");
        logger.info("CustomCommandLine.run");
        logger.warn("CustomCommandLine.run");
        logger.debug("CustomCommandLine.run");
        logger.trace("CustomCommandLine.run");
        logger.error("CustomCommandLine.run");

        logger.info(demoConfig.toString());
        logger.info(name);


        System.out.println("---------------------------------------");
    }
}
