package ru.qa.lesson.lesson_9;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class Test2_Logos extends BaseTest {

    @Test
    public void testPaymentLogos() {
        driver.get("https://mts.by");

        // Закрываем куки
        try {
            WebElement cookieCancel = driver.findElement(By.xpath("//button[contains(text(), 'Отклонить')]"));
            cookieCancel.click();
        } catch (Exception e) {
            // Игнорируем
        }

        // Находим форму оплаты
        WebElement form = driver.findElement(By.id("pay-connection"));

        // Находим все логотипы платежных систем внутри формы
        List<WebElement> logos = form.findElements(By.cssSelector("img.payment-system-logo"));

        // Проверяем, что логотипы существуют
        assertFalse(logos.isEmpty(), "Логотипы платёжных систем не найдены!");

        System.out.println(" Тест 2 пройден: найдено " + logos.size() + " логотипов платёжных систем.");
    }
}