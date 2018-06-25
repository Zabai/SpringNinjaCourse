package com.zarmas.ninjabackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class NinjaBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(NinjaBackendApplication.class, args);
    }
}
