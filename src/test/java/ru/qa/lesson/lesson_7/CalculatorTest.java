package ru.qa.lesson.lesson_7;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class CalculatorTest {
    @Test
    public void testAdd() {
        assertEquals(Calculator.add(2, 3), 5);
    }

    @Test
    public void testSubtract() {
        assertEquals(Calculator.subtract(3, 2), 1);
    }

    @Test
    public void testMultiply() {
        assertEquals(Calculator.multiply(2, 3), 6);
    }

    @Test
    public void testDivide() {
        assertEquals(Calculator.divide(6, 3), 2.0, 0.001);
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void testDivideByZero() {
        Calculator.divide(5, 0);
    }
}