package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationListener;

@SpringBootApplication
@EnableConfigurationProperties(DatabaseProperties.class)
public class Application implements ApplicationListener<ApplicationReadyEvent> {

    private final Logger log = LoggerFactory.getLogger(Application.class);
    private final DatabaseProperties databaseProperties;

    public Application(DatabaseProperties databaseProperties) {
        this.databaseProperties = databaseProperties;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        log.info("Database username=[{}] password=[{}]", databaseProperties.getUsername(), databaseProperties.getPassword());
    }

}
