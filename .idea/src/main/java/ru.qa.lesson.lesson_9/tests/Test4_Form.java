package ru.qa.lesson.lesson_9.tests;

import org.openqa.selenium.WebDriver;
import ru.qa.lesson.lesson_9.pages.MainPage;
import ru.qa.lesson.lesson_9.pages.PaymentFormPage;
import ru.qa.lesson.lesson_9.utils.DriverFactory;

public class Test4_Form {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getDriver();
        try {
            driver.get("https://mts.by");
            MainPage mainPage = new MainPage(driver);
            PaymentFormPage paymentFormPage = mainPage.goToPaymentForm();

            // Обработка кук (если нужно)
            mainPage.handleCookies();

            // Заполнение формы
            paymentFormPage.fillPhoneField("297777777");
            paymentFormPage.fillSumField("100");
            paymentFormPage.clickContinueButton();

            // Добавляем паузу для загрузки нового окна
            Thread.sleep(4000);

            // Проверяем данные в новом окне
            String amountText = paymentFormPage.getPaymentAmountText();
            String phoneText = paymentFormPage.getPaymentPhoneText();
            boolean isCardLabelVisible = paymentFormPage.isCardDetailsLabelVisible();

            System.out.println(" Тест 4 выполнен:");
            System.out.println(" - Сумма в новом окне: " + amountText);
            System.out.println(" - Телефон в новом окне: " + phoneText);
            System.out.println(" - Наличие надписи для ввода реквизитов карты: " + (isCardLabelVisible ? "Да" : "Нет"));

            // Проверяем, что кнопка "Продолжить" была нажата и открылось новое окно
            // (это подразумевается, если мы смогли получить данные из нового окна)

        } catch (Exception e) {
            System.out.println(" Ошибка: " + e.getMessage());
        } finally {
            DriverFactory.quitDriver();
        }
    }
}