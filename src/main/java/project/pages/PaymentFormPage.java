package project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PaymentFormPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By amountSpan = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/div");
    private final By detailsSpan = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/div/div[2]");
    private final By backButton = By.xpath("/html/body/app-root/div/div/app-header/header/div/app-back-navigation/div/div");
    private final By cardIconsContainer = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div");

    public PaymentFormPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public String getAmountText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(amountSpan)).getText();
    }

    public String getDetailsText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(detailsSpan)).getText();
    }

    public void clickBack() {
        wait.until(ExpectedConditions.elementToBeClickable(backButton)).click();
    }

    public int getCardIconsCount() {
        var container = wait.until(ExpectedConditions.visibilityOfElementLocated(cardIconsContainer));
        return container.findElements(By.tagName("img")).size();
    }
}