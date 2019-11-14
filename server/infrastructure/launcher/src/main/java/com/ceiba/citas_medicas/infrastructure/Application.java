package com.ceiba.citas_medicas.infrastructure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:repository.properties")
@PropertySource("classpath:api.properties")
@SpringBootApplication(scanBasePackages = {"com.ceiba.citas_medicas"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
