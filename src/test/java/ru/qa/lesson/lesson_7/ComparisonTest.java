package ru.qa.lesson.lesson_7;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class ComparisonTest {
    @Test
    public void testGreater() {
        assertEquals(Comparison.compare(5, 3), "больше");
    }

    @Test
    public void testLesser() {
        assertEquals(Comparison.compare(2, 5), "меньше");
    }

    @Test
    public void testEqual() {
        assertEquals(Comparison.compare(4, 4), "равно");
    }
}