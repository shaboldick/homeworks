package ru.qa.lesson.lesson_9.tests;

import org.openqa.selenium.WebDriver;
import ru.qa.lesson.lesson_9.pages.MainPage;
import ru.qa.lesson.lesson_9.utils.DriverFactory;

public class Test2_Logos {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getDriver();
        try {
            driver.get("https://mts.by");
            MainPage mainPage = new MainPage(driver);

            int logoCount = mainPage.getLogoCount();

            if (logoCount > 0) {
                System.out.println(" Тест 2 пройден: найдено " + logoCount + " логотипов");
            } else {
                System.out.println("❌ Ошибка: логотипы не найдены!");
            }
        } finally {
            DriverFactory.quitDriver();
        }
    }
}