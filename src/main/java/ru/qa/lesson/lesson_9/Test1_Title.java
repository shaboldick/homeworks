package ru.qa.lesson.lesson_9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1_Title {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://mts.by");

            WebElement title = driver.findElement(
                    By.xpath("//h2[contains(text(), 'Онлайн пополнение')]")
            );

            String actualText = title.getText();

            // 5. Проверяем, что текст совпадает
            if (actualText.contains("Онлайн пополнение") && actualText.contains("без комиссии")) {
                System.out.println(" Тест 1 пройден: заголовок найден и верный");
                System.out.println("Текст заголовка: " + actualText);
            } else {
                System.out.println(" Ошибка: заголовок не совпадает!");
                System.out.println("Было: " + actualText);
            }

        } finally {
            driver.quit();
        }
    }
}