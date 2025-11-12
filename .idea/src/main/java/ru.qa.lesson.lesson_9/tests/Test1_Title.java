package ru.qa.lesson.lesson_9.tests;

import org.openqa.selenium.WebDriver;
import ru.qa.lesson.lesson_9.pages.MainPage;
import ru.qa.lesson.lesson_9.utils.DriverFactory;

public class Test1_Title {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getDriver();
        try {
            driver.get("https://mts.by");
            MainPage mainPage = new MainPage(driver);

            String actualText = mainPage.getTitleText();

            if (actualText.contains("Онлайн пополнение") && actualText.contains("без комиссии")) {
                System.out.println(" Тест 1 пройден: заголовок найден и верный");
                System.out.println("Текст заголовка: " + actualText);
            } else {
                System.out.println(" Ошибка: заголовок не совпадает!");
                System.out.println("Было: " + actualText);
            }
        } finally {
            DriverFactory.quitDriver();
        }
    }
}