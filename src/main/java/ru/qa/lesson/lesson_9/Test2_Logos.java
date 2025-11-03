package ru.qa.lesson.lesson_9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class Test2_Logos {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://mts.by");

            WebElement partnersBlock = driver.findElement(By.className("pay__partners"));

            List<WebElement> logos = partnersBlock.findElements(By.tagName("li"));

            if (logos.size() > 0) {
                System.out.println(" Тест 2 пройден: найдено " + logos.size() + " логотипов");
            } else {
                System.out.println("❌ Ошибка: логотипы не найдены!");
            }

        } finally {
            driver.quit();
        }
    }
}