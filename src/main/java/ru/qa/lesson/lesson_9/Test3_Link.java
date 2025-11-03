package ru.qa.lesson.lesson_9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;

public class Test3_Link {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://mts.by");

            Thread.sleep(2000);
            try {
                WebElement cookieCancel = driver.findElement(By.xpath("//button[contains(text(), 'Отклонить')]"));
                cookieCancel.click();
                System.out.println(" Куки отклонены");
            } catch (Exception e) {
                System.out.println(" Окно кук не найдено");
            }

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
            System.out.println(" Чат-кнопка удалена из DOM");

            WebElement link = driver.findElement(By.linkText("Подробнее о сервисе"));

            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].scrollIntoView({block: 'center', behavior: 'smooth'});",
                    link
            );
            Thread.sleep(800); // даём время прокрутке

            link.click();

            Thread.sleep(2000);

            String newUrl = driver.getCurrentUrl();
            if (!newUrl.equals("https://mts.by")) {
                System.out.println(" Тест 3 пройден: ссылка работает");
                System.out.println("Новый URL: " + newUrl);
            } else {
                System.out.println(" Ошибка: URL не изменился");
            }

        } catch (Exception e) {
            System.out.println(" Ошибка: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}