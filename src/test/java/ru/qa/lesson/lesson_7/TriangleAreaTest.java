package ru.qa.lesson.lesson_7;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class TriangleAreaTest {
    @Test
    public void testValidTriangle() {
        double area = TriangleArea.calculate(3, 4, 5);
        assertEquals(area, 6.0, 0.001);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testInvalidTriangle() {
        TriangleArea.calculate(1, 1, 3);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testNegativeSide() {
        TriangleArea.calculate(-1, 2, 3);
    }
}