package ru.qa.lesson.lesson_9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test4_Form {
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
                System.out.println(" Куки не найдены — продолжаем");
            }

            WebElement form = driver.findElement(By.id("pay-connection"));

            WebElement phoneInput = form.findElement(By.id("connection-phone"));
            phoneInput.clear();
            phoneInput.sendKeys("297777777");

            WebElement sumInput = form.findElement(By.id("connection-sum"));
            sumInput.clear();
            sumInput.sendKeys("100");

            WebElement continueButton = form.findElement(By.xpath(".//button[contains(text(), 'Продолжить')]"));

            continueButton.click();

            Thread.sleep(3500);

            System.out.println(" Тест 4 выполнен: форма заполнена и кнопка нажата, открылась форма оплаты");

        } catch (Exception e) {
            System.out.println(" Ошибка: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}