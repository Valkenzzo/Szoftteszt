package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {


    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void additionWorks() {

        assertEquals(5, calculator.add(2, 3));
    }

    @Test
    void subtractionWorks() {


        assertEquals(-1, calculator.subtract(2, 3));
    }

    @Test
    void multiplicationWorks() {


        assertEquals(6, calculator.multiply(2, 3));
    }
}