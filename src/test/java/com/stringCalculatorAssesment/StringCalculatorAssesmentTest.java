package com.stringCalculatorAssesment;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StringCalculatorAssesmentTest {
    private final StringCalculatorAssesment calculator = new StringCalculatorAssesment();

    @Test
    void add_emptyString(){
        assertEquals(0,calculator.add(""));
    }

}