package ru.qa.lesson.lesson_9.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PaymentFormPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Локаторы формы
    private By formLocator = By.id("pay-connection");
    private By phoneInputLocator = By.id("connection-phone");
    private By sumInputLocator = By.id("connection-sum");
    private By continueButtonLocator = By.xpath(".//button[contains(text(), 'Продолжить')]");

    // Локаторы для проверки нового окна (после нажатия "Продолжить")
    private By paymentAmountLocator = By.xpath("//div[contains(@class, 'payment-details')]//span[contains(text(), 'Сумма:')]");
    private By paymentPhoneLocator = By.xpath("//div[contains(@class, 'payment-details')]//span[contains(text(), 'Телефон:')]");
    private By cardDetailsLabelLocator = By.xpath("//label[contains(text(), 'Номер карты')]");

    public PaymentFormPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Методы для заполнения формы
    public void fillPhoneField(String phoneNumber) {
        WebElement form = wait.until(ExpectedConditions.visibilityOfElementLocated(formLocator));
        WebElement phoneInput = form.findElement(phoneInputLocator);
        phoneInput.clear();
        phoneInput.sendKeys(phoneNumber);
    }

    public void fillSumField(String sum) {
        WebElement form = wait.until(ExpectedConditions.visibilityOfElementLocated(formLocator));
        WebElement sumInput = form.findElement(sumInputLocator);
        sumInput.clear();
        sumInput.sendKeys(sum);
    }

    public void clickContinueButton() {
        WebElement form = wait.until(ExpectedConditions.visibilityOfElementLocated(formLocator));
        WebElement continueButton = form.findElement(continueButtonLocator);
        continueButton.click();
    }

    // Методы для проверки нового окна (после нажатия "Продолжить")
    public String getPaymentAmountText() {
        WebElement amountElement = wait.until(ExpectedConditions.visibilityOfElementLocated(paymentAmountLocator));
        return amountElement.getText();
    }

    public String getPaymentPhoneText() {
        WebElement phoneElement = wait.until(ExpectedConditions.visibilityOfElementLocated(paymentPhoneLocator));
        return phoneElement.getText();
    }

    public boolean isCardDetailsLabelVisible() {
        try {
            WebElement label = wait.until(ExpectedConditions.visibilityOfElementLocated(cardDetailsLabelLocator));
            return label.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Метод для получения текста плейсхолдера (надписи в незаполненном поле)
    public String getPhonePlaceholderText() {
        WebElement form = wait.until(ExpectedConditions.visibilityOfElementLocated(formLocator));
        WebElement phoneInput = form.findElement(phoneInputLocator);
        return phoneInput.getAttribute("placeholder");
    }

    public String getSumPlaceholderText() {
        WebElement form = wait.until(ExpectedConditions.visibilityOfElementLocated(formLocator));
        WebElement sumInput = form.findElement(sumInputLocator);
        return sumInput.getAttribute("placeholder");
    }
}