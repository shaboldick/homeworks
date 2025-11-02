package ru.qa.lesson;

import org.testng.annotations.Test;
import org.testng.Assert;

public class NumberComparatorTest {

    @Test
    public void testCompareGreater() {
        Assert.assertEquals(NumberComparator.compare(5, 3), 1);
    }

    @Test
    public void testCompareLess() {
        Assert.assertEquals(NumberComparator.compare(2, 7), -1);
    }

    @Test
    public void testCompareEqual() {
        Assert.assertEquals(NumberComparator.compare(4, 4), 0);
    }
}