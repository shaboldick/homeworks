package ru.qa.lesson.lesson_7;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ComparisonTest {
    @Test
    void testGreater() {
        assertEquals("больше", Comparison.compare(5, 3));
    }

    @Test
    void testLesser() {
        assertEquals("меньше", Comparison.compare(2, 5));
    }

    @Test
    void testEqual() {
        assertEquals("равно", Comparison.compare(4, 4));
    }
}