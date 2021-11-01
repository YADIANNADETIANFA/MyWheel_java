package com.example.springbootwheel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBootWheelApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWheelApplication.class, args);
    }

}
