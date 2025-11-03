package ru.qa.lesson.lesson_7;

public class Comparison {
    public static String compare(int a, int b) {
        if (a > b) return "больше";
        if (a < b) return "меньше";
        return "равно";
    }
}