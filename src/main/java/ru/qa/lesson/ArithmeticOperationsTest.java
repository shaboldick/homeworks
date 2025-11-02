package ru.qa.lesson;

import org.testng.annotations.Test;
import org.testng.Assert;

public class ArithmeticOperationsTest {

    @Test
    public void testAdd() {
        Assert.assertEquals(ArithmeticOperations.add(2, 3), 5);
    }

    @Test
    public void testSubtract() {
        Assert.assertEquals(ArithmeticOperations.subtract(5, 2), 3);
    }

    @Test
    public void testMultiply() {
        Assert.assertEquals(ArithmeticOperations.multiply(4, 5), 20);
    }

    @Test
    public void testDivide() {
        Assert.assertEquals(ArithmeticOperations.divide(10, 2), 5.0, 0.001);
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void testDivideByZero() {
        ArithmeticOperations.divide(10, 0);
    }
}