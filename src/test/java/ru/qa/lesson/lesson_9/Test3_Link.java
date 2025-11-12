package ru.qa.lesson.lesson_9;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class Test3_Link extends BaseTest {

    @Test
    public void testMoreInfoLink() {
        driver.get("https://mts.by");

        // Закрываем куки
        try {
            WebElement cookieCancel = driver.findElement(By.xpath("//button[contains(text(), 'Отклонить')]"));
            cookieCancel.click();
        } catch (Exception e) {
            // Игнорируем
        }

        // Удаляем чат-кнопку, если она мешает
        ((JavascriptExecutor) driver).executeScript(
                "try {" +
                        "  var chatButton = document.querySelector('a.webim_button');" +
                        "  if (chatButton) {" +
                        "    chatButton.remove();" +
                        "    console.log('Чат-кнопка удалена');" +
                        "  }" +
                        "} catch(e) {" +
                        "  console.log('Не удалось удалить чат:', e);" +
                        "}"
        );

        // Находим ссылку
        WebElement link = driver.findElement(By.linkText("Подробнее о сервисе"));

        // Прокручиваем до элемента
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center', behavior: 'smooth'});",
                link
        );

        // Кликаем по ссылке
        link.click();

        // Ждем изменения URL
        String currentUrl = driver.getCurrentUrl();
        String originalUrl = "https://mts.by";

        // Проверяем, что URL изменился
        assertNotEquals(originalUrl, currentUrl, "URL не изменился после клика по ссылке.");

        System.out.println(" Тест 3 пройден: ссылка работает");
        System.out.println("Новый URL: " + currentUrl);
    }
}