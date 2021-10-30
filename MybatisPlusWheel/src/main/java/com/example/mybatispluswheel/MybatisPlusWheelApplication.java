package com.example.mybatispluswheel;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.mybatispluswheel.dao")
public class MybatisPlusWheelApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusWheelApplication.class, args);
    }

}
