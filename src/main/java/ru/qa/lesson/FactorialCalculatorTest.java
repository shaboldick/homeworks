package ru.qa.lesson;

import org.testng.annotations.Test;
import org.testng.Assert;

public class FactorialCalculatorTest {

    @Test
    public void testFactorialZero() {
        Assert.assertEquals(FactorialCalculator.factorial(0), 1L);
    }

    @Test
    public void testFactorialFive() {
        Assert.assertEquals(FactorialCalculator.factorial(5), 120L);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFactorialNegative() {
        FactorialCalculator.factorial(-1);
    }
}