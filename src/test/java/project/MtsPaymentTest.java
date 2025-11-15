package project;

import org.junit.jupiter.api.Test;
import project.pages.HomePage;
import project.pages.PaymentFormPage;

import static org.junit.jupiter.api.Assertions.*;

public class MtsPaymentTest extends BaseTest {

    @Test
    public void testFullMtsPaymentScenario() {
        HomePage home = new HomePage(driver);
        PaymentFormPage payment = new PaymentFormPage(driver);

        // 1. Открыть сайт
        home.open();

        // 2. Отклонить куки и убрать чат
        home.dismissCookies();
        home.removeChatButton();

        // 3. Проверить заголовок
        String title = home.getBlockTitle();
        assertTrue(title.contains("Онлайн пополнение") && title.contains("без комиссии"));

        // 4. Проверить логотипы
        assertTrue(home.getLogosCount() > 0, "Нет логотипов платёжных систем");

        // 5. Проверить активный сервис
        assertEquals("Услуги связи", home.getActiveServiceText());

        // 6. Заполнить форму
        home.fillPhone("297777777");
        home.fillSum("100");
        home.clickContinue();

        // 7. Проверить данные на новой странице
        assertEquals("100.00 BYN", payment.getAmountText());
        String details = payment.getDetailsText();
        assertTrue(details.contains("375297777777"), "Неверный номер");
        assertTrue(details.contains("Услуги связи"), "Неверный тип услуги");

        // 8. Проверить иконки карт (должно быть 5)
        assertEquals(5, payment.getCardIconsCount(), "Неверное количество иконок");

        // 9. Вернуться назад
        payment.clickBack();

        // 10. Проверить ссылку "Подробнее о сервисе"
        home.clickMoreInfoLink();

        // Переключаемся на новую вкладку (если открылась)
        String original = driver.getWindowHandles().iterator().next();
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(original)) {
                driver.switchTo().window(handle);
                break;
            }
        }

        // Проверяем наличие заголовка "Оплата банковской картой"
        assertTrue(driver.getPageSource().contains("Оплата банковской картой"));
    }
}