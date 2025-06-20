package com.github.yuriserka.rocketseatinvoices.worker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.github.yuriserka.rocketseatinvoices.core.config.ApplicationPropertySource;

@SpringBootApplication(scanBasePackages = "com.github.yuriserka.rocketseatinvoices")
@ApplicationPropertySource
public class WorkerApplication {
	public static void main(String[] args) {
		SpringApplication.run(WorkerApplication.class, args);
	}
}
