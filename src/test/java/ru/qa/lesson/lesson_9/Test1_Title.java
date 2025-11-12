package ru.qa.lesson.lesson_9;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Test1_Title extends BaseTest {

    @Test
    public void testBlockTitle() {
        driver.get("https://mts.by");

        // Закрываем куки, если они есть
        try {
            WebElement cookieCancel = driver.findElement(By.xpath("//button[contains(text(), 'Отклонить')]"));
            cookieCancel.click();
        } catch (Exception e) {
            // Если кнопки нет, игнорируем
        }

        // Находим заголовок блока
        WebElement title = driver.findElement(By.xpath("//h2[contains(text(), 'Онлайн пополнение')]"));

        String actualText = title.getText();

        // Проверяем, что текст содержит оба ожидаемых слова
        assertTrue(actualText.contains("Онлайн пополнение") && actualText.contains("без комиссии"),
                "Заголовок не совпадает! Было: " + actualText);

        System.out.println(" Тест 1 пройден: заголовок найден и верный");
        System.out.println("Текст заголовка: " + actualText);
    }
}