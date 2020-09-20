package com.poc.spring.aop.sla;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.poc.spring.aop.sla")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
