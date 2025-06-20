package com.github.yuriserka.rocketseatinvoices.core;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.github.yuriserka.rocketseatinvoices.core.config.ApplicationPropertySource;

@SpringBootApplication(scanBasePackages = "com.github.yuriserka.rocketseatinvoices")
@ApplicationPropertySource
@EnableRabbit
public class CoreApplication {
    public static void main(String[] args) {
        SpringApplication.run(CoreApplication.class, args);
    }
}
