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

    @Test
    void add_forSingleNumber(){
        assertEquals(1,calculator.add("1"));
    }

    @Test
    void add_forMultipleNumbers(){
        assertEquals(6,calculator.add("1,5"));
    }
}