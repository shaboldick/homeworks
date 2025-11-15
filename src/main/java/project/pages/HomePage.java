package project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By cookieButton = By.xpath("//button[contains(text(), 'Отклонить')]");
    private final By chatButton = By.cssSelector("a.webim_button");
    private final By blockTitle = By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/h2");
    private final By paymentLogos = By.cssSelector("img.payment-system-logo");
    private final By activeService = By.xpath("//span[@class='select__now']");
    private final By phoneInput = By.id("connection-phone");
    private final By sumInput = By.id("connection-sum");
    private final By continueButton = By.xpath("//*[@id='pay-connection']/button");
    private final By moreInfoLink = By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/a");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void open() {
        driver.get("https://mts.by");
    }

    public void dismissCookies() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(cookieButton)).click();
        } catch (Exception ignored) {}
    }

    public void removeChatButton() {
        ((JavascriptExecutor) driver).executeScript(
                "var el = document.querySelector('a.webim_button'); if (el) el.remove();"
        );
    }

    public String getBlockTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(blockTitle)).getText();
    }

    public int getLogosCount() {
        return driver.findElements(paymentLogos).size();
    }

    public String getActiveServiceText() {
        return driver.findElement(activeService).getText();
    }

    public void fillPhone(String phone) {
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(phoneInput));
        el.clear();
        el.sendKeys(phone);
    }

    public void fillSum(String sum) {
        WebElement el = driver.findElement(sumInput);
        el.clear();
        el.sendKeys(sum);
    }

    public void clickContinue() {
        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
    }

    public void clickMoreInfoLink() {
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(moreInfoLink));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", link);
        link.click();
    }
}