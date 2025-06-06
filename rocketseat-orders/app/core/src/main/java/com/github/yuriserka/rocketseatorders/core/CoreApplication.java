package com.github.yuriserka.rocketseatorders.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.github.yuriserka.rocketseatorders.core.config.ApplicationPropertySource;
import com.github.yuriserka.rocketseatorders.core.config.JpaConfiguration;

@SpringBootApplication(scanBasePackages = "com.github.yuriserka.rocketseatorders")
@Import(JpaConfiguration.class)
@ApplicationPropertySource
public class CoreApplication {
    public static void main(String[] args) {
        SpringApplication.run(CoreApplication.class, args);
    }
}
