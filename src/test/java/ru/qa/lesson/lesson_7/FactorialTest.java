package ru.qa.lesson.lesson_7;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class FactorialTest {
    @Test
    public void testFactorialZero() {
        assertEquals(Factorial.calculate(0), 1);
    }

    @Test
    public void testFactorialPositive() {
        assertEquals(Factorial.calculate(5), 120);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFactorialNegative() {
        Factorial.calculate(-1);
    }
}