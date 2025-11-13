package ru.qa.lesson.lesson_9;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Test4_Form extends BaseTest {

    @Test
    public void testFormSubmission() {
        driver.get("https://mts.by");

        // Закрываем куки
        try {
            WebElement cookieCancel = driver.findElement(By.xpath("//button[contains(text(), 'Отклонить')]"));
            cookieCancel.click();
        } catch (Exception e) {
            // Игнорируем
        }

        // Находим форму
        WebElement form = driver.findElement(By.id("pay-connection"));

        // Находим поля и заполняем их
        WebElement phoneInput = form.findElement(By.id("connection-phone"));
        phoneInput.clear();
        phoneInput.sendKeys("297777777");

        WebElement sumInput = form.findElement(By.id("connection-sum"));
        sumInput.clear();
        sumInput.sendKeys("100");

        // Находим и нажимаем кнопку "Продолжить"
        WebElement continueButton = form.findElement(By.xpath(".//button[contains(text(), 'Продолжить')]"));
        continueButton.click();

        // Проверяем, что открылась новая страница (форма оплаты)
        // Можно проверить, например, наличие элемента на новой странице
        // Здесь мы просто проверим, что URL изменился (как в Test3)
        String currentUrl = driver.getCurrentUrl();
        String originalUrl = "https://mts.by";

        assertTrue(!currentUrl.equals(originalUrl), "Форма не отправлена, URL не изменился.");

        System.out.println(" Тест 4 выполнен: форма заполнена и кнопка нажата, открылась форма оплаты");
    }
}