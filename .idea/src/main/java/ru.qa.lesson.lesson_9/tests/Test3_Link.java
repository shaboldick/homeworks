package ru.qa.lesson.lesson_9.tests;

import org.openqa.selenium.WebDriver;
import ru.qa.lesson.lesson_9.pages.MainPage;
import ru.qa.lesson.lesson_9.utils.DriverFactory;

public class Test3_Link {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getDriver();
        try {
            driver.get("https://mts.by");
            MainPage mainPage = new MainPage(driver);

            mainPage.handleCookies();
            mainPage.removeChatButton();
            mainPage.clickMoreInfoLink();

            String newUrl = mainPage.getCurrentUrl();

            if (!newUrl.equals("https://mts.by")) {
                System.out.println(" Тест 3 пройден: ссылка работает");
                System.out.println("Новый URL: " + newUrl);
            } else {
                System.out.println(" Ошибка: URL не изменился");
            }
        } catch (Exception e) {
            System.out.println(" Ошибка: " + e.getMessage());
        } finally {
            DriverFactory.quitDriver();
        }
    }
}