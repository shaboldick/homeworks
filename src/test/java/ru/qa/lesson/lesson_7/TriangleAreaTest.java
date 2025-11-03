package ru.qa.lesson.lesson_7;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TriangleAreaTest {
    @Test
    void testValidTriangle() {
        double area = TriangleArea.calculate(3, 4, 5);
        assertEquals(6.0, area, 0.001);
    }

    @Test
    void testInvalidTriangle() {
        assertThrows(IllegalArgumentException.class, () -> TriangleArea.calculate(1, 1, 3));
    }

    @Test
    void testNegativeSide() {
        assertThrows(IllegalArgumentException.class, () -> TriangleArea.calculate(-1, 2, 3));
    }
}