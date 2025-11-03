package ru.qa.lesson.lesson_7;

public class Factorial {
    public static int calculate(int n) {
        if (n < 0) throw new IllegalArgumentException("Факториал отрицательного числа не определён");
        if (n == 0 || n == 1) return 1;
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}