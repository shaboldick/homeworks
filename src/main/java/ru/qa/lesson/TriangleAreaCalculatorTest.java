package ru.qa.lesson;

import org.testng.annotations.Test;
import org.testng.Assert;

public class TriangleAreaCalculatorTest {

    @Test
    public void testAreaRightTriangle() {
        Assert.assertEquals(TriangleAreaCalculator.area(3, 4, 5), 6.0, 0.001);
    }

    @Test
    public void testAreaIsoscelesTriangle() {
        Assert.assertEquals(TriangleAreaCalculator.area(5, 5, 6), 12.0, 0.001);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testInvalidTriangle() {
        TriangleAreaCalculator.area(1, 1, 3);
    }
}