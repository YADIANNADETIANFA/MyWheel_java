package com.example.springbootwheel.myWheel;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@SpringBootTest
public class Wheel_1 {

    /**
     * 时间格式与String转化
     * */
    @Test
    public void test1() {
        DateTimeFormatter dateTimeFormatterDat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter dateTimeFormatterTim = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        try {
            LocalDate localDate = LocalDate.of(2019, 9, 10);
            LocalDateTime localDateTime = LocalDateTime.of(2019, 9, 10, 11, 10, 9);
            String strDat = localDate.format(dateTimeFormatterDat);
            String strTim = localDateTime.format(dateTimeFormatterTim);
            System.out.println(strDat);
            System.out.println(strTim);
        } catch (DateTimeException e) {
            e.printStackTrace();
        }

        try {
            LocalDate localDate1 = LocalDate.parse("2017-12-13", dateTimeFormatterDat);
            LocalDateTime localDateTime1 = LocalDateTime.parse("2017-12-13 10:11:12", dateTimeFormatterTim);
            System.out.println(localDate1);
            System.out.println(localDateTime1);
        } catch (DateTimeParseException e) {
            e.printStackTrace();
        }
    }


}
