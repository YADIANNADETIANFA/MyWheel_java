package com.example.springbootwheel.myWheel;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@SpringBootTest
public class Wheel_1 {

    @Test
    public void test1() {
        LocalDate localDate = LocalDate.of(2019, 9, 100);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String str = localDate.format(dateTimeFormatter);
        System.out.println(str);
    }
}
